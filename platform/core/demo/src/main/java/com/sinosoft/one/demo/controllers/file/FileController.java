package com.sinosoft.one.demo.controllers.file;

import com.google.common.io.ByteStreams;
import com.sinosoft.one.mvc.util.MvcPathUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Raw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * file download demo controller
 * User: carvin
 * Date: 12-8-7
 * Time: 下午11:25
 */
@Path("/download")
public class FileController {
    @Get("/word")
    public Reply downloadWord(Invocation invocation) throws IOException {
        String fileName = "测试文件.docx";
        InputStream inputStream = MvcPathUtil.getDirectoryStream(invocation, "tempFiles/" + fileName);
        return Replys.with(inputStream).as(Raw.class).downloadFileName(fileName);
    }

    @Get("/excel")
    public Reply downloadExcel(Invocation invocation) throws IOException {
        String fileName = "测试文件.xlsx";
        InputStream inputStream = MvcPathUtil.getDirectoryStream(invocation, "tempFiles/" + fileName);

        return Replys.with(ByteStreams.toByteArray(inputStream)).as(Raw.class).downloadFileName(fileName);
    }

    @Get("/txt")
    public Reply downloadTxt(Invocation invocation) throws Exception {
        String fileName = "测试文件.txt";
        File file = MvcPathUtil.getDirectoryFile(invocation, "tempFiles/" + fileName);

        return Replys.with(file).as(Raw.class).downloadFileName(fileName);
    }

    @Get("/main")
    public String fileMain() {
        return "file";
    }
}
