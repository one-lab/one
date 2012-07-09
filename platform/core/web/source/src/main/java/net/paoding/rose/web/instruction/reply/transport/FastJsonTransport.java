package net.paoding.rose.web.instruction.reply.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
public class FastJsonTransport extends Json {
	private final PropertyFilter filter = new PropertyFilter() {
		public boolean apply(Object source, String name, Object value) {
			return false;
		}
	};
	private final SerializeWriter writer = new SerializeWriter();

	@Override
	public <T> T in(InputStream in, Class<T> type) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void out(OutputStream out, Class<T> type, T data)
			throws IOException {
		JSONSerializer serializer = new JSONSerializer(writer);
		serializer.getPropertyFilters().add(filter);
		serializer.write(data);
		String text = out.toString();
		out.write(text.getBytes("UTF-8"));
		out.close();
	}

}
