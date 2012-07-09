package net.paoding.rose.mock.controllers.reply;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.instruction.reply.Reply;
import net.paoding.rose.web.instruction.reply.transport.Json;


public class ReplyController {

    @Get
    public Reply<String> haha() {
        return Reply.with("hello reply");
    }

    @Post
    public Reply<Student> gaga() {
        return Reply.with(new Student("1", "carvin")).as(Json.class);
    }
    
    class Student {
    	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String id;
    	private String name;
    	
    	public Student(String id, String name) {
    		this.id = id;
    		this.name = name;
    	}
    }
}
