//Ƕ�ױ�ǩҳѡ��
function selectTag(showContent,selfObj){
  // ������ǩ
  var tag = document.getElementById("tags").getElementsByTagName("li");
  var taglength = tag.length;
  for(i=0; i<taglength; i++){
    tag[i].className = "";
  }
  selfObj.parentNode.className = "selectTag";
  // ��������
  for(i=0; j=document.getElementById("tagContent"+i); i++){
    j.style.display = "none";
  }
  document.getElementById(showContent).style.display = "block";
}
//Ƕ�׶�����ǩҳѡ��
function selectLevelTag(tagIndex,showContent,selfObj){
  // ������ǩ
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
  // ��������
  if(tagIndex==3){
      //�������� ��tagContent30 �� tagContent31 ���Բ�ͬʱ����
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
