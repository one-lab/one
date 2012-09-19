package com.sinosoft.one.mvc.web.instruction.reply;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.web.Invocation;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.sinosoft.one.mvc.util.DateFormatMode;
import com.sinosoft.one.mvc.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;

class EntityReplyMaker<E> extends ReplyMaker implements EntityReply<E> {
	private Class<? extends AbstractTransport> transport = Text.class;
	private E entity;

	private String[] excludes;
	private String[] includes;
	private DateFormatMode dateFormatMode;
	private String dateFormatString;
	
	public EntityReplyMaker(E entity) {
		this.entity = entity;
	}
	
	public EntityReply<E> type(String mediaType) {
		super.setType(mediaType);
		return this;
	}

	public EntityReply<E> headers(Map<String, String> headers) {
		setHeaders(headers);
		return this;
	}

    public EntityReply<E> header(String key, String value) {
        addHeader(key, value);
        return this;
    }

    public EntityReply<E> downloadFileName(String fileName) {
        StringsEx.nonEmpty(fileName, "file name cannot be null or empty!");
        String tempFileName = fileName;
        try {
            tempFileName = new String(tempFileName.getBytes("GBK"),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        addHeader("Content-disposition", "attachment; filename=\"" + tempFileName + "\"");
        return this;
    }

    @Override
	public void populate(Invocation inv) throws IOException {
		HttpServletResponse response = inv.getResponse();
		// This is where we take all the builder values and encode them in the
		// response.
		AbstractTransport transport = inv.getApplicationContext().getBean(
				this.transport);
        setResponse(response, transport.contentType());

		if (null != entity) {
			if (entity instanceof InputStream) {
				// Stream the response rather than marshalling it through a
				// transport.
				InputStream inputStream = (InputStream) entity;
				try {
					ByteStreams.copy(inputStream, response.getOutputStream());
				} finally {
					inputStream.close();
				}
			} else if(entity instanceof byte[]) {
                transport.out(response.getOutputStream(),
                        entity);
            } else if(entity instanceof File) {
                InputStream inputStream = new FileInputStream((File)entity);
                try {
                    ByteStreams.copy(inputStream, response.getOutputStream());
                } finally {
                    inputStream.close();
                }
            }else {
				if(StringUtils.isEmpty(dateFormatString)) {
					dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
				}
				transport.setDateFormatString(dateFormatString);
				if(ArrayUtils.isNotEmpty(excludes)) {
					transport.setExcludes(excludes);
					transport.setIncludes(null);
				} else if(ArrayUtils.isNotEmpty(includes)) {
					transport.setIncludes(includes);
					transport.setExcludes(null);
				} else {
					transport.setIncludes(null);
					transport.setExcludes(null);
				}

				transport.out(response.getOutputStream(),
						entity);
			}
		}
	}

	public EntityReply<E> as(Class<? extends AbstractTransport> transport) {
		Preconditions.checkArgument(null != transport,
				"Transport class cannot be null!");
		this.transport = transport;
		return this;
	}

	public EntityReply<E> excludes(String excludeFields) {
		Preconditions.checkNotNull(excludeFields, "The exclude fields cannot be null.");
		return excludes(excludeFields.split(","));
	}

	public EntityReply<E> includes(String includeFields) {
		Preconditions.checkNotNull(includeFields, "The include fields cannot be null.");
		return includes(includeFields.split(","));
	}

	public EntityReply<E> dateFormatString(String dateFormatString) {
		if(Strings.isNullOrEmpty(dateFormatString)) {
			this.dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
		} else {
			this.dateFormatString = dateFormatString;
		}
		return this;
	}

	public EntityReply<E> dateFormatMode(DateFormatMode dateFormatMode) {
		if(dateFormatMode == null) {
			this.dateFormatMode = DateFormatMode.YYYYMMDDHHMMSS;
		} else {
			this.dateFormatMode = dateFormatMode;
		}
		this.dateFormatString = this.dateFormatMode.toString();
		return this;
	}

	public EntityReply<E> excludes(String... excludeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.includes), "Invoked includes method, cannot inovke the excludes method at the same time.");
		this.excludes = excludeFields;
		return this;
	}

	public EntityReply<E> includes(String... includeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.excludes), "Invoked excludes method, cannot inovke the inlcudes method at the same time.");
		this.includes = includeFields;
		return this;
	}

	public EntityReply<E> status(int code) {
		setStatus(code);
		return this;
	}
}
