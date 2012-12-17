//嵌套标签页选择
function selectTag(showContent,selfObj){
  // 操作标签
  var tag = document.getElementById("tags").getElementsByTagName("li");
  var taglength = tag.length;
  for(i=0; i<taglength; i++){
    tag[i].className = "";
  }
  selfObj.parentNode.className = "selectTag";
  // 操作内容
  for(i=0; j=document.getElementById("tagContent"+i); i++){
    j.style.display = "none";
  }
  document.getElementById(showContent).style.display = "block";
}
//嵌套二级标签页选择
function selectLevelTag(tagIndex,showContent,selfObj){
  // 操作标签
  var tag = document.getElementsByTagName("ul");
  var taglength = tag.length;
  for(i=0; i<taglength; i++){
  	if(i==tagIndex) 
  	{
  	   var li = tag[i].getElementsByTagName("li");
  	   for(j=0; j<li.length; j++)
  	   {
         li[j].className = "";
       }
    }
  }
  selfObj.parentNode.className = "selectTag";
  // 操作内容
  if(tagIndex==3){
      //单独处理 因tagContent30 和 tagContent31 可以不同时出现
      if(typeof(document.all.tagContent30)=="object"){
        document.getElementById("tagContent30").style.display = "none";
      }
      if(typeof(document.all.tagContent31)=="object"){
        document.getElementById("tagContent31").style.display = "none";
      }      

  	  for(i=2; j=document.getElementById("tagContent"+tagIndex+i); i++){
	    j.style.display = "none";
	  }
  
  }else{
	  for(i=0; j=document.getElementById("tagContent"+tagIndex+i); i++){
	    j.style.display = "none";
	  }
  }

  document.getElementById(showContent).style.display = "block";
}

function setStyle(){
  var tag = document.getElementById("tagContent").getElementsByTagName("div");
  var taglength = tag.length;
  for(i=0; i<taglength; i++){
    tag[i].style.width = document.body.offsetWidth;
    tag[i].style.Height = document.body.offsetHeight;
  }
}
