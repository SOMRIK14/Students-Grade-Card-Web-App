package org.jsp.Students_marks_card.helper;

import org.jsp.Students_marks_card.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class ResponseStructure <S>
{
  String msg;
  int status_code;
  
  S data; //it will help to store single information, as well as multiple information,so make it generic with any value

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public int getStatus_code() {
	return status_code;
}

public void setStatus_code(int status_code) {
	this.status_code = status_code;
}

public S getData() {
	return data;
}

public void setData(S data) {
	this.data = data;
}


  
}
