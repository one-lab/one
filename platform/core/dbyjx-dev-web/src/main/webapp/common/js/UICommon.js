/****************************************************************************
 * DESC       �����ú�����������
* Author     : �й������Ŀ��
 * CREATEDATE ��2002-06-14
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 *           zhouxianli   2002-07-08       �����������maxleng����
 *           zhouxianli   2002-08-26       ����
 *           sunchenggang 2002-09-03       �޸�collectByCurrency�ű�
 *           sunchenggang 2002-09-04       ���Ӱ��ұ𡢱�������־���ܽű�collectByCurrencyAndCalculateFlag
 *           zhouxianli   2002-09-05       ���ӷ���,һ�θ����е�input������onchange�������ұ���ԭ��onchange()
 *           sunchenggang 2002-09-06       ���Ӱ��仯�����ܽű�showCollectChange
 *           zhouxianli   2002-09-09       add method numberFormat()
 *           zhouxianli   2002-09-10       add method setReadonlyOfAllInput(),undoSetReadonlyOfAllInput();
 *           sunchenggang 2002-09-11       add method calTimeSinglePremium()
 *                                         �޸�deleteRowForPG����flag="D"ʱ���ָ�ԭֵ
 *           zhouxianli   2002-09-12       �޸�setOnchangeOfAllInputΪsetOnchangeOfTable(),һ�θ�һ��table��
 *                                         input������onchange�������ұ���ԭ��onchange()
 *                                         �޸�setTitleOfAllInput();
 *           zhouxianli   2002-09-13       add method isEmpty(field)  return true/false.
 *           sunchenggang 2002-09-18       add method setBackColorOfTable()
 *           luxupan      2002-10-17       ����showSpan��hideSpan����
 *                                             getTableFieldsName����
 *                                             setFlagPG����
 *           zhouxianli   2002-10-21       add method setTableDisabled(PageCode,Value)
 *                                         //Ϊһҳ�����е�Ԫ������disabled,value = true or false
 *           zhouxianli   2002-10-22       add method functionReturnFalse() and functionReturnTrue()
 *           zhouxianli   2002-10-23       ���ӿɷ��������б�
 *           zhouxianli   2002-10-24       �Ż�getElementOrder() and getElementCount()
 *           zhouxianli   2002-11-08       ����checkDecimal��У��������������Ƿ���decimal������
 *           zhouxianli   2002-11-11       �޸�checkDateTime,����Year-Minute�ķ�ʽ
 *           zhouxianli   2002-11-14       ���Ӻ���setCheckBoxReadonly()������checkbox��Readonly
 *           zhouxianli   2002-11-14       ���Ӻ���pressCustom()��checkCustom()
 *           zhouxianli   2002-11-21       �޸ĺ���setOption,֧��Select����
 *           zhouxianli   2002-11-21       ��������compareFullDate,//�Ƚ����������ַ���
                                           date1=date2�򷵻�0 , date1>date2�򷵻ش���0������, date1<date2�򷵻�С��0������
 *           zhouxianli   2002-11-22       ��������setObjectDisplay�����ö����Ƿ���ʾ
 *           lijiyaun     2002-12-03       ��������checkHour()Ч������Сʱ�Ƿ�Ϸ�
 *           renyiqun     2003-02-26							�޸�relate()����
 *           xuxinyuan    2003-04-18       ��������checkBetweenDate����У���ѯ����������
 *           xiaojian     2003-04-22       ��������compareFullTime(date1,date2)�Ƚ��������ڣ�����Сʱ�ͷ��ӣ��ַ���
 *           zhangying    2003-05-27       ��������checkNull(field)�ж�������Ϊ�գ�Ϊ����ʾ�����ǲ���������
 *           sunfei       2004-12-17       ��������ShowContractNo,����ǳ��ӵĳ�����ʾ��ͬ��Ϣ
 ************************************************************************************/

/************************************************************************************
  ������        ��������                ��������
  ϵͳ����
                functionReturnFalse     ����false
                functionReturnTrue      ����true
                functionDoNothing       �պ���,ʲôҲ����
                setObjectDisplay        ���ö����Ƿ���ʾ
                getElementIndex         ����Ԫ����Form(fm)�е�˳��û���򷵻�-1
                getElementCount         ������Form�е�ͬ��Ԫ�أ�û���򷵻�0
                getElementOrder         �õ�Ԫ����Form�е�ͬ��Ԫ���е�˳��,��1��ʼ����
                errorMessage            ����������Ϣ
                cancelForm              Ĭ�ϵ�ȡ����ť�������������ض���һ���հ��ļ�

  ���ڴ�������
                getNextDateFullDate     �õ���n��
                getNextMonthFullDate    �õ���n��
                getNextYearFullDate     �õ���n��
                convertFullDateToString �õ����ڵ��ַ���������ʽ���������ΪDate����,�����������Ĭ��Ϊ����
        
        				getBeforeDateFullDate   �õ���N��  
								getBeforeMonthFullDate  �õ���n��
								getBeforeYearFullDate	  �õ���n��

  �����жϺ���
                isDate                  ��������Ƿ�������,�Ƿ���true,���򷵻�false
                isInteger               ��������Ƿ�������,��ֻ�����ַ�0123456789,�Ƿ���true,���򷵻�false
                isNumeric               ��������Ƿ�������,�Ƿ���true,���򷵻�false

  ������У�麯��
                checkDatetime           ���������Ϊ�գ�У���������ֵ�Ƿ�ΪDatetime��,��������򵯳���ʾ���޷��뿪
                checkDecimal            ���������Ϊ�գ�У���������ֵ�Ƿ�Ϊ���������ɷ�Χ�ڵ�Decimal��,��������򵯳���ʾ���޷��뿪
                checkFullDate           ���������Ϊ�գ�У���������ֵ�Ƿ�ΪFullDate(�������յ�Date)��,��������򵯳���ʾ���޷��뿪
                checkInteger            ���������Ϊ�գ�У���������ֵ�Ƿ�ΪInteger��,��������򵯳���ʾ���޷��뿪
                checkSmallint           ���������Ϊ�գ�У���������ֵ�Ƿ�ΪSmallint��,��������򵯳���ʾ���޷��뿪
                checkLength             ���������Ϊ�գ�У���������ֵ�Ƿ�Ϊ��������󳤶ȵ��ַ���,��������򵯳���ʾ���޷��뿪
                checkCustom             ���������Ϊ�գ�У���������ֵ�Ƿ�Ϊָ����ʽ��ֵ,��������򵯳���ʾ���޷��뿪
                checkNull               �ж�������Ϊ�գ�Ϊ����ʾ�����ǲ���������

  �ַ�����������
                leftTrim                ���������ַ���ȥ����࿪ʼ�Ŀո����ַ���
                rightTri                ���������ַ���ȥ���Ҳ࿪ʼ�Ŀո����ַ���
                trim                    ���������ַ���ȥ���������࿪ʼ�Ŀո����ַ���
                replace                 ���������ַ���ȫ���滻��Ľ��
                newString               �������ַ������ƣ�鲢����

  �����򰴼�����
                pressDatetime           ������ֻ������Datetime������
                pressDecimal            ������ֻ������Decimal������
                pressFullDate           ������ֻ������FullDate������
                pressHour               ������ֻ������Hour����
                pressInteger            ������ֻ������Integer������
                pressCustom             ������ֻ������ָ�������ݣ��ù������ʽ��ʾ ��pressCustom(event,/[\d]/) ֻ����������

  ���ִ�������
                point                   ������ľ��ȶ���ֵ��ʽ��
                pointTwo                ����ֵ��0.00��ʽ��
                pointFour               ����ֵ��0.0000��ʽ��
                round                   ������ľ��ȶ���ֵ��������
                numberFormat            �����ָ�ʽ��(ʵ��ǧ��λ��ʾ��)��delimiterCharĬ��Ϊ"," precisionĬ��Ϊ3
                retExpTest              ִ������������

  ����
                getTableFieldsName      �õ�table���һ��tbody������������������
                setOnchangeOfElement
                setOnchangeOfTable        һ�θ����е�input������onchange�������ұ���ԭ��onchange()���������ڶ��е���һ��/��һ��ģʽ
                setOnchangeOfTableSpecial һ�θ����е�input������onchange�������ұ���ԭ��onchange()�����ڶ��е���һ��/��һ��ģʽ
                setOption                 �ָ���벢����select������ĸ�ʽ: ֵFIELD_SEPARATOR�ı�GROUP_SEPARATORֵFIELD_SEPARATOR�ı�...
                setReadonlyOfAllInput     һ�θ����е�text,textarea����Ϊreadonly,select-one���ֻ������ǰѡ����̲��ֿ���
                setTitleOfAllInput        һ�θ����е�element��value����title
                setCheckBoxReadonly       ��CheckBox����Ϊֻ����ɶ�д


  Ӧ�ú���

                showCollectItem         ��ʾ��������
                showCollectItemApd      ��ʾ���ܸ�����
                showCollectCurrency     ��ʾ���ұ����
                showCollectChange       ��ʾ���仯������
                showCollectItemC        ��ʾ���ջ�������
                showCollectItemY        ��ʾ���ջ�������
                showCollectItemApdC     ��ʾ���ջ��ܸ�����


  ######### δ�����

/************************************************************************************/


//���峣��
var FIELD_SEPARATOR = "_FIELD_SEPARATOR_";   //�ֶ�֮��ķָ��
var GROUP_SEPARATOR = "_GROUP_SEPARATOR_";     //һ�����֮��ķָ��
var DATE_DELIMITER="-";       //���ڷָ���
var BGCOLORU="#FFFF00";        //�޸�(��ɫ)
var BGCOLORI="#00F0F0";       //����(��ɫ)
var BGCOLORD="#778899";       //ɾ��(��ɫ)

var MAX_SMALLINT = Math.pow(2,15) - 1;
var MIN_SMALLINT = -MAX_SMALLINT;

var MAX_INTEGER  = Math.pow(2,31) - 1;
var MIN_INTEGER  = -MAX_INTEGER;
var MIN_HOUR     = 0;
var MAX_HOUR     = 24;

//var DATEVALUEDELIMITER=":";       //���ڷָ���
//var NAMEVALUEDELIMITER=":";       //��������ֵ�ķָ���
//var SBCCASECOLON="��";
//var FIELDDELIMITER="|";       //��֮��ķָ���
//var SBCCASEVERTICAL="��";
//var RECORDDELIMITER="^";      //��¼֮��ķָ���
//var CODE_DELIMITER = "-";    //���������֮�����ʾ�ָ���


function functionReturnFalse()
{
  return false;
}

function functionReturnTrue()
{
  return true;
}

function functionCancelFocus()
{
  errorMessage("ֻ����������ѡ��");
  this.blur();
  window.focus();
  return false;
}


//empty function
function functionDoNothing()
{
  //do nothing
}

function getFunctionName(FunctionDesc)
{
  var start = 0;
  var end = 0;
  var tempValue = FunctionDesc;
  tempValue = tempValue.toString();
  start = tempValue.indexOf("{") + 2;
  end = tempValue.lastIndexOf("}");
  tempValue = tempValue.substr(start,end-start);
  tempValue = replace(tempValue,"return","");
  tempValue = replace(tempValue,";",",");
  tempValue = trim(tempValue);
  if(tempValue.charAt(tempValue.length-1)==",")
  {
    tempValue = tempValue.substring(0,tempValue.length-1) + ";";
  }
  return tempValue;
}

//RegExt Test
function regExpTest(source,re)
{
  var result = false;

  if(source==null || source=="")
    return false;

  if(source==re.exec(source))
    result = true;

  return result;
}

//���ö����Ƿ���ʾ
function setObjectDisplay(ID,flag)
{
  var obj = document.all(ID);
  var intCount = 0;
  var i = 0;
  if(obj==null)
  {
    errorMessage("setObjectDisplay('" + ID + "','" + flag + "')�ĵ�һ����������ȷ");
    return;
  }
  intCount = obj.length;
  //����
  if(intCount==null)
  {
    //modify begin by lir ,shenzhen,2004-10-30 ����y��
    //if(flag==true)
      if(flag==true && ID!="KindCode_Y")
    //modify end by lir ,shenzhen,2004-10-30 ����y��
      obj.style.display = "";
    else
      obj.style.display = "none";
  }
  else //���
  {
    for(i=0;i<intCount;i++)
    {
    //modify begin by lir ,shenzhen,2004-10-30 ����y��
    //if(flag==true)
      if(flag==true && ID!="KindCode_Y")
    //modify end by lir ,shenzhen,2004-10-30 ����y��
        obj[i].style.display = "";
      else
        obj[i].style.display = "none";
    }
  }
}
//����Ԫ����Form�е�˳��û���򷵻�-1
function getElementIndex(field)
{
  var intElementIndex = -1;

  for(var i=0;i<fm.elements.length;i++) //����fm���Ԫ��
  {
    if(fm.elements[i]==field)
    {
      intElementIndex=i;
      break;
    }
  }
  return intElementIndex;
}


//������Form�е�ͬ��Ԫ�أ�û���򷵻�0, frmĬ��Ϊ��ǰҳ���fm
function getElementCount(strFieldName,frm)
{
  var intCount = 0;
  var frmForm = (frm==null?document.fm:frm);

  try
  {
    intCount = eval( frmForm.all(strFieldName).length );
    if(isNaN(intCount)) intCount = 1;
  }
  catch(E)
  {
    intCount = 0;
  }

  //select����������⴦��
  if(intCount>1 && frmForm.all(strFieldName)[0].tagName=="OPTION")
  {
    intCount = 1;
  }

  return intCount;
}

//�õ�Ԫ����Form�е�ͬ��Ԫ���е�˳��,frmĬ��Ϊ��ǰҳ���fm
function getElementOrder(field,frm)
{
  var intOrder = 0;
  var intCount = getElementCount(field.name,frm);
  var frmForm = (frm==null?document.fm:frm);

  if(intCount>1)
  {
    for(var i=0;i<intCount;i++)
    {
      if(frmForm.all(field.name)[i].name==field.name)
      {
        intOrder++;
      }
      if(frmForm.all(field.name)[i]==field)
      {
        break;
      }
    }
  }
  else
  {
    intOrder = 1;
  }
  return intOrder;
}

//���������Ƿ������ڵ�У�飬splitChar����ȱʡΪ"-"
function isDate(date,splitChar)
{
  var charSplit = (splitChar==null?"-":splitChar);
  var strValue = date.split(charSplit);

  if(strValue.length!=3) return false;
  if(!isInteger(strValue[0]) || !isInteger(strValue[1]) || !isInteger(strValue[2]) ) return false;

  var intYear  = parseInt(strValue[0],10);
  var intMonth = parseInt(strValue[1],10)-1;
  var intDay   = parseInt(strValue[2],10);

  var dt = new Date(intYear,intMonth,intDay);
  if( dt.getFullYear() != intYear ||
      dt.getMonth() != intMonth ||
      dt.getDate() != intDay
     )
  {
    return false;
  }
  return true;
}

/**
 @Author     : �й������Ŀ��
 @description ������������� ���yyyy/mm/dd  2003/2/4  ->2003/04/04
 @param       ���ڴ�
 @param       �ָ���
 @return      ��
 */
 function formatFullDate(field,date_Delimiter)
{
  var strValueDate  ;  //���ڴ������ֵ
  var strDate = field.value;
  var strReturnDate ;  //����ɵĸ�ʽ��
  strValueDate = strDate.split(date_Delimiter);
  if(strValueDate[0].length==2)
  {
     strValueDate[0]= "20" + strValueDate[0];
  }
  if(strValueDate[1].length==1)
  {
     strValueDate[1]= "0" + strValueDate[1];
  }

  if(strValueDate[2].length==1)
  {
     strValueDate[2]= "0" + strValueDate[2];
  }
  //������ɴ�
  strReturnDate = strValueDate[0] + date_Delimiter + strValueDate[1] + date_Delimiter + strValueDate[2];
  field.value = strReturnDate ;
  return true;
}
/**
 @Author     : �й������Ŀ��
 @description ������������� ���yyyy/mm/dd  2003/2/4  ->2003/04/04
 @param       ���ڴ�
 @param       �ָ���
 @return      ��
 */
 function formatChgFullDate(strDate,date_Delimiter,date_Delimiter1)
{
  var strValueDate  ;  //���ڴ������ֵ
  var strReturnDate ;  //����ɵĸ�ʽ��
  strValueDate = strDate.split(date_Delimiter);
  if(strValueDate[0].length==2)
  {
     strValueDate[0]= "20" + strValueDate[0];
  }
  if(strValueDate[1].length==1)
  {
     strValueDate[1]= "0" + strValueDate[1];
  }

  if(strValueDate[2].length==1)
  {
     strValueDate[2]= "0" + strValueDate[2];
  }
  //������ɴ�
  strReturnDate = strValueDate[0] + date_Delimiter1 + strValueDate[1] + date_Delimiter1 + strValueDate[2];
  return strReturnDate;
}

//�������������
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }
  if(isNumeric(strValue ))
  {
    if(strValue.length > 6 && strValue.length < 9)
    {
        strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);

        field.value = strValue;
    }
     else
     {
     	errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
        field.value="";
        field.focus();
        field.select();
        return false;
     }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }

  return true;
}

//�������������,��checkFullDate������������������������,֮����":" �ָ�,
//���� 20030523:20040312,
//���� 2003/03/04:2004/09/12
function checkBetweenDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }

  //������ֱ�ӷ���
  var index = strValue.indexOf(":");
  if (index < 0)
  {
    if(isNumeric(strValue ))
    {
      if(strValue.length>6)
      {
        strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);
        field.value = strValue;
      }

      if(!isDate(strValue,DATE_DELIMITER) && !isDate(strValue))
      {
       errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
       field.value="";
       field.focus();
       field.select();
       return false;
      }
    }
    return true;
  }

  var beginDate = strValue.substring(0,index);
  var endDate  = strValue.substring(index + 1);

  if(isNumeric(beginDate ))
  {
    beginDate = beginDate.substring(0,4) + DATE_DELIMITER + beginDate.substring(4,6) + DATE_DELIMITER + beginDate.substring(6);
  }
  if(isNumeric(endDate ))
  {
    endDate = endDate.substring(0,4) + DATE_DELIMITER + endDate.substring(4,6) + DATE_DELIMITER + endDate.substring(6);
  }

  if(!isDate(beginDate,DATE_DELIMITER))
  {
    errorMessage("���������Ϊ�Ƿ�����,����������");
    field.focus();
    field.select();
    return false;
  }
  if(!isDate(endDate,DATE_DELIMITER))
  {
    errorMessage("���������Ϊ�Ƿ�����,����������");
    field.focus();
    field.select();
    return false;
  }
   field.value = beginDate + ":" + endDate;
   return true;
}


//�õ���n��
function getNextDateFullDate(strDate,intCount)
{
  /*modify by weishixin add begin 2003-07-26*/
  //ԭ��2003-07-26���ָ�ʽJS new Date����,ת��2003/07/26
  strDate = replace(strDate,"-","/");
  /*modify by weishixin add end 2003-07-26*/
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }
  var nextDateInMS = tempDate.getTime() + (intCount * 24 * 60 * 60 * 1000 );

  var strReturn = convertFullDateToString(new Date(nextDateInMS));
  return strReturn;
}


//�õ���n����
function getNextMonthFullDate(strDate,intCount)
{
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }

  tempDate.setMonth(tempDate.getMonth() + intCount );
  var strReturn = convertFullDateToString(tempDate);
  return strReturn;
}


//�õ���n����
function getNextYearFullDate(strDate,intCount)
{
  strDate = replace(strDate,"-","/");
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }
  tempDate.setFullYear(tempDate.getFullYear() + intCount );
  var strReturn = convertFullDateToString(tempDate);
  return strReturn;
}


//�õ����ڵ��ַ���������ʽ���������ΪDate����
//�����������Ĭ��Ϊ����
function convertFullDateToString(date)
{
  var chgMonth;//�ı��ʽ����

  var chgDay  ;//�ı��ʽ������

  if(date==null)
  {
    date = new Date();
  }

  var strDate = "";
  //modify 2003-07-26 start weishixin
  //ԭ�����ո�ʽ���mm/dd��7/1�ĳ�07/01
  /*
  strDate = date.getFullYear() + DATE_DELIMITER +
              (date.getMonth() + 1) + DATE_DELIMITER +
            date.getDate();
  */

  if (date.getMonth()+1<10)
  {
     chgMonth = date.getMonth() + 1 ;//
     chgMonth ="0" + chgMonth ;
  }
  else
  {
     chgMonth = date.getMonth() + 1 ;//
  }
  if (date.getDate()<10)
  {
     chgDay = date.getDate();//
     chgDay ="0" + chgDay ;
  }
  else
  {
     chgDay = date.getDate() ;//
  }
  strDate = date.getFullYear() + DATE_DELIMITER +
            chgMonth + DATE_DELIMITER +
            chgDay;
  //modify 2003-07-26 start weishixin
  return strDate;
}

/*modify by zhanjie begin 0724*/
//Դ����û�п��ǵ��Էָ��"/"�Ĵ��������޸�
/*
//�Ƚ����������ַ���
// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
function compareFullDate(date1,date2)
{
  alert("date1:"+date1);
  alert("date2:"+date2);
  var strValue1=date1.split(DATE_DELIMITER);
  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10));

  var strValue2=date2.split(DATE_DELIMITER);
  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10));

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else

    return -1;
}
*/

//�Ƚ����������ַ���
// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
function compareFullDate(date1,date2)
{
  //��ȡ�ַ����ķָ����

  strdate1_split = get_datesplit(date1);
  strdate2_split = get_datesplit(date2);
  var strValue1=date1.split(strdate1_split);
  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10));
  var strValue2=date2.split(strdate2_split);
  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10));

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else
    return -1;
}

//��ȡ�����ַ����ķָ��
function get_datesplit(strdate)
{
	if (strdate.match("/")) return "/"
	if (strdate.match("-")) return "-"
}

/*modify by zhanjie end 0724*/




//�Ƚ��������ڣ�����Сʱ�ͷ��ӣ��ַ���
// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
function compareFullTime(date1,date2)
{
  date1=replace(date1," ","-");
  date1=replace(date1,":","-");
  date2=replace(date2," ","-");
  date2=replace(date2,":","-");

  var strValue1=date1.split(DATE_DELIMITER);
  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10),parseInt(strValue1[3],10),parseInt(strValue1[4],10));

  var strValue2=date2.split(DATE_DELIMITER);
  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10),parseInt(strValue2[3],10),parseInt(strValue2[4],10));

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else
    return -1;
}

//ȥ���ַ���ͷ�ո�
function leftTrim(strValue)
{
  var re =/^\s*/;
  if(strValue==null)
    return null;

 strValue= "" + strValue;
  var strReturn = strValue.replace(re,"");

  return strReturn;
}

//ȥ���ַ���β�ո�
function rightTrim(strValue)
{
  var re =/\s*$/;
  if(strValue==null)
    return null;

  var strReturn = strValue.replace(re,"");

  return strReturn;
}

//ȥ���ַ���ͷβ�ո�
function trim(s)
{
  var strReturn;
  strReturn = leftTrim(s);
  strReturn = rightTrim(strReturn);

  return strReturn;
}

//���������Ƿ���������У��,��ֻ�����ַ�0123456789
function isInteger(strValue)
{
  var result = regExpTest(strValue,/\d+/g);
  return result;
}

//���������Ƿ������ֵ�У��
function isNumeric(strValue)
{
  var result = regExpTest(strValue,/\d*[.]?\d*/g);
  return result;
}

//�ж��Ƿ��д��ĸ
function isUpperLetter(strValue)
{
   var result = regExpTest(strValue,/^[A-Z]+$/);
   return result;
}


//�뿪��ʱ������У��
function checkInteger(field,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(!isInteger(strValue))
  {
    errorMessage("������Ϸ�������");
    field.focus();
    field.select();
    return false;
  }

  MinValue = parseInt(MinValue,10);
  if(isNaN(MinValue))
    MinValue = MIN_INTEGER;

  MaxValue = parseInt(MaxValue,10);
  if(isNaN(MaxValue))
    MaxValue = MAX_INTEGER;
  var value = parseInt(strValue,10);
  if(isNaN(value) || value>MaxValue || value<MinValue)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����(integer),��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//�뿪��ʱ������У��
function checkSmallint(field,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(!isInteger(strValue))
  {
    errorMessage("������Ϸ�������");
    field.focus();
    field.select();
    return false;
  }

  MinValue = parseInt(MinValue,10);
  if(isNaN(MinValue))
    MinValue = MIN_SMALLINT;

  MaxValue = parseInt(MaxValue,10);
  if(isNaN(MaxValue))
    MaxValue = MAX_SMALLINT;

  var value = parseInt(strValue,10);
  if(isNaN(value) || value>MaxValue || value<MinValue)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����(smallint),��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
    field.focus();
    field.select();
    return false;
  }
  return true;
}


//�뿪��ʱ������У��Decimal
function checkDecimal(field,p,s,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";

  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(!isNumeric(strValue))
  {
    errorMessage("������Ϸ�������");
    field.focus();
    field.select();
    return false;
  }
  p = parseInt(p,10);
  s = parseInt(s,10);

  var pLength;
  var sLength;
  var position = strValue.indexOf(".");
  if(position>-1)
  {
    pLength = position;
    sLength = strValue.length - position - 1;
  }
  else
  {
    pLength = strValue.length;
    sLength = 0;
  }

  if(pLength>(p-s) || sLength>s)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����,����λ�Ϊ" + (p-s) + ",С��λ�Ϊ" + s);
    field.focus();
    field.select();
    return false;
  }

  var value = parseFloat(strValue);
  if(MaxValue!=null && MinValue!=null && trim(MaxValue)!="" && trim(MinValue)!="")
  {
    MinValue = parseFloat(MinValue);
    MaxValue = parseFloat(MaxValue);
    if(isNaN(value) || value>MaxValue || value<MinValue)
    {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ����,��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
      field.focus();
      field.select();
      return false;
    }
  }

  return true;
}

//���������У��,regΪ�������ʽ
function checkCustom(field,reg,typeDesc)
{
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(typeDesc==null)
    typeDesc = reg;

  if(strValue=="")
  {
    return true;
  }

  var r=reg.test(strValue);

  if (r==false)
  {
    errorMessage("������Ϸ���" + desc +"\n��������Ϊ" +typeDesc + "\n��ʽΪ" + reg);
    field.focus();
    field.select();
    return false;
  }

  return r;
}

//�뿪��ʱ������У��Datetime
function checkDatetime(field,from,to)
{
  field.value = trim(field.value);
  field.value = replace(field.value,"/","-");
  var strValue=field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(strValue=="")
  {
    return true;
  }
  from = from.toLowerCase();
  to = to.toLowerCase();

  if(from=="year" && to=="month")
  {
    if(isNumeric(field.value))
    {
      if(strValue.length>4)
      {
        strValue = strValue.substring(0,4) + "-" + strValue.substring(4);
        field.value = strValue;
      }
    }

    if(regExpTest(strValue,/[\d]{4}[-][\d]{1,2}/)==false)
    {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ����ʱ�䣬��ʽΪYYYY-MM ����YYYYMM");
      field.focus();
      field.select();
      return false;
    }

    var month = parseInt(replace(strValue.substring(strValue.indexOf("-")+1),"0",""),10);
    if(!(month>=1 && month<=12))
    {
      errorMessage("������Ϸ����·������·���Ӧ��Ϊ���ڵ���1С�ڵ���12��������");
      field.focus();
      field.select();
      return false;
    }
  }
  else if(from=="year" && to=="minute")
  {

    if(isNumeric(field.value))
    {
      if(strValue.length==12)
      {
        strValue = strValue.substring(0,4) + "-" + strValue.substring(4,6) + "-" + strValue.substring(6,8) + " " + strValue.substring(8,10) + ":" + strValue.substring(10,12);
        field.value = strValue;
      }
    }

    if(regExpTest(strValue,/[\d]{4}[-][\d]{1,2}[-][\d]{1,2} [\d]{1,2}:[\d]{1,2}/)==false)
    {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ����ʱ�䣬��ʽΪYYYY-MM-DD hh:mm ����YYYYMMDDhhmm");
      field.focus();
      field.select();
      return false;
    }

    var pos = strValue.indexOf(" ");
    var tempDate = strValue.substring(0,pos);
    strValue = strValue.substring(pos+1);
    if(!isDate(tempDate,"-"))
    {
      errorMessage("������Ϸ������ڣ�");
      field.focus();
      field.select();
      return false;
    }
    pos = strValue.indexOf(":");
    var hour = parseInt(strValue.substring(0,pos),10);
    var minute = parseInt(strValue.substring(pos+1),10);
    if(!(hour>=0 && hour<=24))
    {
      errorMessage("������Ϸ���Сʱ����Сʱ��Ӧ��Ϊ���ڵ���0С�ڵ���24��������");
      field.focus();
      field.select();
      return false;
    }
    if(!(minute>=0 && minute<=59))
    {
      errorMessage("������Ϸ��ķ�������������Ӧ��Ϊ���ڵ���0С�ڵ���59��������");
      field.focus();
      field.select();
      return false;
    }
  }
  else
  {
    errorMessage("Not support now!");
    return false;
  }
  return true;
}


//����
function hasValue(field)
{
  if(field.value=="")
    return false;
  else
    return true;
}

//�������򰴼�ʱ��У��,regΪ�������ʽ
function pressCustom(e,reg)
{
  var value = String.fromCharCode(e.keyCode);
  var r=reg.test(value);
  return r;
}

//�������򰴼�ʱ������У��
function pressInteger(e)
{
  var value = String.fromCharCode(e.keyCode);
  if(value>=0 && value<=9)
    return true;
  else
    return false;
}

//�������򰴼�ʱ��СʱУ��
function pressHour(e)
{
  return pressInteger(e);
}


//�������򰴼�ʱ������У��
function pressDecimal(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value==".")
    return true;
  else
    return false;
}

//�������򰴼�ʱ������У��
function pressDecimal1(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="."|| value=="-")
    return true;
  else
    return false;
}
//�������򰴼�ʱ������У��
function pressFullDate(e)
{
	
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="/" || value=="-"){
    return true;
  }
  else
    return false;
}

//�������򰴼�ʱ��DatetimeУ��
function pressDatetime(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="/" || value=="-" || value==":" || value==" ")
    return true;
  else
    return false;
}


//��һ������
function openWindow(strURL,strName)
{
  var newWindow = window.open(strURL,strName,'width=640,height=480,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
  return newWindow;
}

//��һ��С����
function openSmallWindow(strURL,strName)
{
  var newWindow = window.open(strURL,strName,'width=350,height=220,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
  return newWindow;
}
//�ָ���벢����select����
//���ĸ�ʽ: ֵFIELD_SEPARATOR�ı�GROUP_SEPARATORֵFIELD_SEPARATOR�ı�...
function setOption(selectName,strValue)
{
  //�鲻�����뷵��
  if(strValue==null || trim(strValue)=="")
  {
    return;
  }
	//alert(selectName);
  var arrayField=strValue.split(GROUP_SEPARATOR);
  var i=0;
  var j=0;
  var intCount = getElementCount(selectName);

  if(intCount>1)
  {
    for(j=0;j<intCount;j++)
    {
      fm.all(selectName)[j].options.length = 0;
    }
  }
  else
  {
    fm.all(selectName).options.length = 0;
  }

  while(i<arrayField.length)
  {
    if(intCount>1)
    {
      for(j=0;j<intCount;j++)
      {
        var option=document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;

        fm.all(selectName)[j].add(option);
      }
    }
    else
    {
        var option=document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;
      fm.all(selectName).add(option);
    }
    i++;
  }
}

/* ��д������ --onkeypressʱ���ø÷��� */
function uppercaseKey()
{
  var keycode = window.event.keyCode;
  if( keycode>=97 && keycode<=122 )
  {
    window.event.keyCode = keycode-32;
  }
}

function setFormAllDisabled()
{
  var i = 0;
  for(i=0;i<fm.elements.length;i++)
  {
    fm.elements[i].disabled=true;
  }
}

function setFormAllEnabled()
{
  var i = 0;
  for(i=0;i<fm.elements.length;i++)
  {
    fm.elements[i].disabled=false;
  }
}

//Ϊһҳ�����е�Ԫ������disabled
//value = true or false
function setTableDisabled(PageCode,Value)
{
  var i = 0;
  var j = 0;
  var elements;
  //�õ�Input�������
  for(i=0;i<document.all(PageCode).tBodies.length;i++)
  {
    elements = document.all(PageCode).tBodies.item(i).getElementsByTagName("input");
    for(j=0;j<elements.length;j++)
    {
      elements[j].disabled=Value;
    }
    //�õ�Select�������
    elements = document.all(PageCode).tBodies.item(i).getElementsByTagName("select");
    for(j=0;j<elements.length;j++)
    {
      elements[j].disabled=Value;
    }
    //�õ�textarea�������
    elements = document.all(PageCode).tBodies.item(i).getElementsByTagName("textarea");
    for(j=0;j<elements.length;j++)
    {
      elements[j].disabled=Value;
    }
  }
}

//���ñ���ɫ
function setBackColor(field,bcolor)
{
  field.style.backgroundColor = bcolor;
}


//�Ƚϱ���������ֵ���ñ���ɫ(����������ѯ��)
function setBackColorOfTable(TableID)
{
  var i = 0;
  //�õ�Input�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].type!="text") continue;
    if(elements[i].value!=elements[i].title)
    {
      setBackColor(elements[i],BGCOLORU);
    }
  }

  //�õ�Select�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].value!=elements[i].title)
    {
      setBackColor(elements[i],BGCOLORU);
    }
  }

  //�õ�textarea�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].value!=elements[i].title)
    {
      setBackColor(elements[i],BGCOLORU);
    }
  }

}


/**
 * �������ַ������ƣ��
 * @param intLength �ַ�������
 * @return �ַ���
 */
function newString(iString, iTimes)
{
  var str = "";
  for (var i = 0 ; i < iTimes; i++)
     str = str + iString;
  return str;
}


//��������������
//��ֵ,����
function round(number,precision)
{
  if(isNaN(number))
    number = 0;
  var prec = Math.pow(10,precision);
  var result = Math.round( number * prec) ;
  result = result/prec;
  return result;
}


//�����ֽ��и�ʽ��,��֤precisionλ
function point(number,precision)
{
  if(isNaN(number))
    number = 0;
  var result = number.toString();
  if(result.indexOf(".")==-1)
    result = result + ".";

  result = result + newString("0",precision);
  result = result.substring(0,precision + result.indexOf(".") + 1);
  return result;
}

//�����ֵ���λ��������
function mathRound(number)
{
  return round(number,2);
}

//�����ְ�0.00��ʽ��
function pointTwo( s )
{
  return point(s,2);
}

//�����ְ�0.0000 ��ʽ��
function pointFour( s )
{
  return point(s,4);
}

//�����ָ�ʽ����delimiterCharĬ��Ϊ"," precisionĬ��Ϊ3
function numberFormat(ivalue,delimiterChar,precision)
{
  if((ivalue==null) || (ivalue==""))
    return "";

  if(delimiterChar==null || delimiterChar=="")
    delimiterChar = ",";

  if(precision==null || precision =="")
    precision = 3;

  var i = 0;
  var ovalue = "";
  var times;

  var avalue = "";
  if(ivalue.indexOf(".")>-1)
  {
    avalue = "." + ivalue.substring(ivalue.indexOf(".")+1);
    ivalue = ivalue.substring(0,ivalue.indexOf("."));
  }

  times = ivalue.length % precision;
  if(times!=0)
  {
    ovalue = ivalue.substring(0,times);
    ivalue = ivalue.substring(times);
  }

  for(i=0;i<ivalue.length;i++)
  {
    if(i%precision==0)
    {
      ovalue += delimiterChar;
    }
    ovalue += ivalue.substring(i,i+1)
  }

  if(ovalue.substring(0,1) == delimiterChar)
    ovalue = ovalue.substring(1);


  return ovalue + avalue;
}


/**
 * ��ʽ������
 * @param value ֵ
 * @param count �ָ�λ�� Ĭ��Ϊ3
 * @param precision С���㱣��λ�� Ĭ��Ϊ2
 * @param delimiterChar �ָ�� Ĭ��Ϊ','
 */
function formatFloat(value,count,precision,delimiterChar)
{
  count = count==null?3:count;
  precision = precision==null?2:precision;
  delimiterChar = delimiterChar==null?",":delimiterChar;

  //lijibin add ����и����򲻲����ʽ��
  var strMinus = "";
  if(value<0)
  {
    strMinus = "-";
    value = -1*value;
  }

  var strReturn = ""; //����ֵ
  var strValue = point(round(value,precision),precision); //��ʽ����ָ��С��λ��

  strReturn = strValue.substring(strValue.length-precision-1);
  strValue = strValue.substring(0,strValue.length-precision-1);
  while(strValue.length>count)
  {
    strReturn = delimiterChar + strValue.substring(strValue.length-count) + strReturn;
    strValue = strValue.substring(0,strValue.length-count);
  }

  strReturn = strMinus + strValue + strReturn;
  return strReturn;
}


//��ʾ��ӡ����
function printWindow(strURL,strWindowName)
{
  var pageWidth=screen.availWidth-10;
  var pageHeight=screen.availHeight-30;
  if (pageWidth<100 )
    pageWidth = 100;

  if (pageHeight<100 )
    pageHeight = 100;

  var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
  newWindow.focus();
  return newWindow;
}


//��ͼƬ����ʾ������
function showImg(imgID,stl)
{
  document.all(imgID).style.display = stl;
}

//���������򳤶�  ��min��max֮��
/**********************************************
  * ������Ŀ��  ������
  * ��������У�麯��  ����������У���ֶγ����ǲ�����min ��max֮�� �ֶβ�����Ϊ��
  *******************************************/
function  checkLength2(field,min,max)
{
 //alert("111111111111111");
 var str;
 var count = 0;
 var value = field.value;
 var minlength = min;
 var maxlength = max;
 var desc = field.description;
 //���description���Բ����ڣ�����name����
  //alert("2222222222222");
 if(desc==null)
 {
  desc = field.name;
 }
  //alert("3333333333");
   if(value=="")
  {
    errorMessage("������"+ desc );
      //field.focus();
      //field.select();
      return false;
  }
  //alert("444444444444");
 if(value.indexOf("^")>-1 ||
     value.indexOf(FIELD_SEPARATOR)>-1 ||
     value.indexOf(GROUP_SEPARATOR)>-1
    )
  {
    errorMessage("^Ϊϵͳ�����ַ������������룡");
    //field.focus();
    //field.select();
    return false;
  }
   //alert("555555555555");
 for(var i=0;i<value.length;i++)
  {
    str = escape(value.charAt(i));
    if(str.substring(0,2)=="%u" && str.length==6)
      count = count + 2;
    else
      count = count + 1;
  }
   //alert("6666666666666666");
  if(count<minlength)
  {
   errorMessage(desc + "��������ݲ�����\n" + desc + "����С����Ϊ" + minlength + "��Ӣ���ַ���\n���������룡");
    //field.focus();
   // field.select();
    return false;
  }
   //alert("777777777777");
  if(count>maxlength)
  {
   errorMessage(desc + "��������ݳ�����\n" + desc + "����󳤶�Ϊ" + maxlength + "��Ӣ���ַ���\n���������룡");
    //field.focus();
    //field.select();
    return false;
  }  
   return true; 
}


/**********************************************
  * ������Ŀ��  ������
  * ���ܺ�У�麯��  ����������У���ֶγ����ǲ�����min ��max֮�� �ֶ�����Ϊ��
  *******************************************/
function  checkLength3(field,min,max)
{
 //alert("111111111111111");
 var str;
 var count = 0;
 var value = field.value;
 var minlength = min;
 var maxlength = max;
 var desc = field.description;
 //���description���Բ����ڣ�����name����
  //alert("2222222222222");
 if(desc==null)
 {
  desc = field.name;
 }
  //alert("3333333333");
   if(value=="")
  {
      //errorMessage("������"+ desc );
      //field.focus();
      //field.select();
      //alert("----����Ϊ��  ����true--------");
      return true;
  }
  //alert("444444444444");
 if(value.indexOf("^")>-1 ||
     value.indexOf(FIELD_SEPARATOR)>-1 ||
     value.indexOf(GROUP_SEPARATOR)>-1
    )
  {
    errorMessage("^Ϊϵͳ�����ַ������������룡");
    //field.focus();
    //field.select();
    return false;
  }
   //alert("555555555555");
 for(var i=0;i<value.length;i++)
  {
    str = escape(value.charAt(i));
    if(str.substring(0,2)=="%u" && str.length==6)
      count = count + 2;
    else
      count = count + 1;
  }
   //alert("6666666666666666");
  if(count<minlength)
  {
   errorMessage(desc + "��������ݲ�����\n" + desc + "����С����Ϊ" + minlength + "��Ӣ���ַ���\n���������룡");
    //field.focus();
   // field.select();
    return false;
  }
   //alert("777777777777");
  if(count>maxlength)
  {
   errorMessage(desc + "��������ݳ�����\n" + desc + "����󳤶�Ϊ" + maxlength + "��Ӣ���ַ���\n���������룡");
    //field.focus();
    //field.select();
    return false;
  }  
   return true; 
}

//���������򳤶�
// ʹ�÷���������ʾ
// <input name = "PolicyNo" maxlength="8" description="������"  onblur="checkLength(this)">
function checkLength(field)
{
  //alert("--------dfdfdfdf-----------");
  var str;
  var count  = 0;
  var value  = field.value;
  var length = field.maxLength;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(value=="")
  {
    return true;
  }

  if(value.indexOf("^")>-1 ||
     value.indexOf(FIELD_SEPARATOR)>-1 ||
     value.indexOf(GROUP_SEPARATOR)>-1
    )
  {
    errorMessage("^Ϊϵͳ�����ַ������������룡");
    field.focus();
    field.select();
    return false;
  }



  //���maxlength���Բ����ڣ��򷵻�
  if(isNaN(parseInt(length,10)))
    return true;

  for(var i=0;i<value.length;i++)
  {
    str = escape(value.charAt(i));
    if(str.substring(0,2)=="%u" && str.length==6)
      count = count + 2;
    else
      count = count + 1;
  }

  if(count>length)
  {
    errorMessage(desc + "��������ݳ�����\n" + desc + "����󳤶�Ϊ" + length + "��Ӣ���ַ���\n���������룡");
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//������������Ϊ��
// ʹ�÷���������ʾ
// <input name = "PolicyNo" maxlength="8" description="������"  onblur="checkNull(this)">
function checkNull(field)
{
  if(!hasValue(field))
  {
    errorMessage("����Ϊ��");
    return false;
  }
}

//�滻�ַ�������
function replace(strExpression,strFind,strReplaceWith)
{
  var strReturn;
  var re = new RegExp(strFind,"g");
  if(strExpression==null)
    return null;

  strReturn = strExpression.replace(re,strReplaceWith);
  return strReturn;
}


//�����������ڵĲ�,���ز������(M)������(D)
//2003/3/17 ��Ϊ(������������2.29��һ��)
function dateDiff(dateStart,dateEnd,MD)
{
  var i;
  if(MD=="D") //��������
  {
    var endTm   = dateEnd.getTime();
    var startTm = dateStart.getTime();
    var diffDay = (endTm - startTm)/86400000 + 1;

    return diffDay;
  }
  else //���¼����
  {
    var endD   = dateEnd.getDate();
    var endM   = dateEnd.getMonth();
    var endY   = dateEnd.getFullYear();
    var startD = dateStart.getDate();
    var startM = dateStart.getMonth();
    var startY = dateStart.getFullYear();

    if(endD>=startD)
    {
      return (endY-startY)*12 + (endM-startM) + 1;
    }
    else
    {
      return (endY-startY)*12 + (endM-startM);
    }
  }
}


//�����������ڵĲ�,���ز������(M)������(D) (����������ʵ������������2.29��һ��)
function dateRealDiff(dateStart,dateEnd,MD)
{
  var i;
  if(MD=="D") //��������
  {
    var endTm   = dateEnd.getTime();
    var startTm = dateStart.getTime();
    var diffDay = (endTm - startTm)/86400000 + 1;
    return diffDay;
  }
  else //���¼����
  {
    var endD   = dateEnd.getDate();
    var endM   = dateEnd.getMonth();
    var endY   = dateEnd.getFullYear();
    var startD = dateStart.getDate();
    var startM = dateStart.getMonth();
    var startY = dateStart.getFullYear();

    if(endD>startD)
    {
      return (endY-startY)*12 + (endM-startM) + 1;
    }
    else
    {
      return (endY-startY)*12 + (endM-startM);
    }
  }
}


function isEmpty(field)
{
  //Liujun_20091101_�㽭��ҵ�ռ���
  if(field==null){
      return true;
  }
  
  if(field.value==null || trim(field.value)=="")
  {
    return true;
  }

  return false;
}

//
//  ҵ�����Javascript
//

//public
//һ�θ����е�element��value����title
function setTitleOfAllInput()
{
  for(var i=0;i<fm.elements.length;i++)
  {
    if(fm.elements[i].type=="checkbox" || fm.elements[i].type=="radio")
      fm.elements[i].title = fm.elements[i].checked;
    else
      fm.elements[i].title = fm.elements[i].value;
  }
}


//public
function setOnchangeOfElement(element)
{
  element.onchange=mainOnchange;
}

//public
//һ�θ����е�input������onchange�������ұ���ԭ��onchange()
//���ڶ��е���һ��/��һ��ģʽ
function setOnchangeOfTableSpecial(TableID)
{
  var i = 0;
  //�õ�Input�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].tableID=TableID;
    elements[i].onchange=mainOnchangeSpecial;
  }
  //�õ�Select�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].tableID=TableID;
    elements[i].onchange=mainOnchangeSpecial;
  }
  //�õ�textarea�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].tableID=TableID;
    elements[i].onchange=mainOnchangeSpecial;
  }
}

//pirvate
function mainOnchangeSpecial()
{
  if(fm.all(this.tableID + "_Flag").value==null ||
    (fm.all(this.tableID + "_Flag").value == "")||
    (fm.all(this.tableID + "_Flag").value == "U"))
  {
    mainOnchangeChangeColor(this);
  }
  if(this.oldOnchange!=null)
  {
    return eval(this.oldOnchange.toString());
  }
}

function setOnchangeOfTable(TableID)
{
  var i = 0;
  //�õ�Input�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].onchange=mainOnchange;
  }
  //�õ�Select�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].onchange=mainOnchange;
  }
  //�õ�textarea�������
  elements = document.all(TableID).tBodies.item(0).getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].onchange!=null)
    {
      elements[i].oldOnchange = getFunctionName(elements[i].onchange.toString());
    }
    elements[i].onchange=mainOnchange;
  }
}

//private

function mainOnchangeChangeColor(field)
{
  if(field.style.backgroundColor.toUpperCase()!=BGCOLORI && field.style.backgroundColor.toUpperCase()!=BGCOLORD)
  {
    if(field.type=="select-one")
    {
      var i = 0;
      for(i=0;i<field.options.length;i++)
      {
        if(field.options[i].value==field.title)
          setBackColor(field.options[i],"");
        else
          setBackColor(field.options[i],BGCOLORU);
      }
    }
    else if(field.type=="checkbox")
    {
      if(trim(""+field.checked)!=trim(""+field.title))
        setBackColor(field,BGCOLORU);
      else
        setBackColor(field,"");
    }
    else if(field.type=="radio")
    {
      var i = 0;
      var obj;
      for(i=0;i<getElementCount(field.name);i++)
      {
        obj = eval("fm." + field.name + "[" + i + "]");
        if(trim(""+obj.checked)!=trim(""+obj.title))
          setBackColor(obj,BGCOLORU);
        else
          setBackColor(obj,"");
      }
    }
    else
    {
      if(field.value!=field.title )
        setBackColor(field,BGCOLORU);
      else
        setBackColor(field,"");
    }
  }
}
//pirvate
function mainOnchange()
{
  mainOnchangeChangeColor(this);
  if(this.oldOnchange!=null)
  {
    return eval(this.oldOnchange.toString());
  }
}

//main onblur
function mainOnblur()
{
  if(this.oldOnblur!=null)
  {
//    alert(this.oldOnblur.toString());
    return eval(this.oldOnblur.toString());
  }
}

//main ondblclick
function mainOndblclick()
{
  if(this.oldOndblclick!=null)
  {
    return eval(this.oldOndblclick.toString());
  }
}

//main onfocus
function mainOnfocus()
{
  if(this.oldOnfocus!=null)
  {
    return eval(this.oldOnfocus.toString());
  }
}

//public
function setCheckBoxReadonly(field,flag)
{
  if(flag==null)
  {
    errorMessage("����setCheckBoxReadonlyʹ�ô���FlagӦ��ΪTrue/Flase!");
    return;
  }

  if(flag==true)
  {
    if(field.setCheckBoxReadonlyFlag!=true)
    {
      field.setCheckBoxReadonlyFlag = true;
      field.oldClassName = field.className;
      field.oldOnclick   = field.onclick;
      field.className = "readonlycheckbox";
      field.onclick = functionReturnFalse;
    }
  }
  else
  {
    if(field.setCheckBoxReadonlyFlag==true)
    {
      field.className = field.oldClassName;
      field.onclick = field.oldOnclick;
      field.setCheckBoxReadonlyFlag = false;
    }
  }
}

//public
function setRadioReadonly(field,flag)
{
  if(flag==null)
  {
    errorMessage("����setRadioReadonlyʹ�ô���FlagӦ��ΪTrue/Flase!");
    return;
  }
  if(flag==true)
  {
    if(field.setRadioReadonlyFlag!=true)
    {
      field.setRadioReadonlyFlag = true;
      field.oldClassName = field.className;
      field.oldOnfocus   = field.onfocus;
      field.className = "readonlyradio";
      field.onfocus = functionCancelFocus;
    }
  }
  else
  {
    if(field.setRadioReadonlyFlag==true)
    {
      field.className = field.oldClassName;
      field.onfocus = field.oldOnfocus;
      field.setRadioReadonlyFlag = false;
    }
  }
}


//public
function setReadonlyOfElement(iElement)
{
  if(iElement.type=="select-one")
  {
    if(iElement.setReadonlyFlag==true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = true;
    }

    var optionTags = new Array();
    var index = 0;
    for(var j=iElement.options.length-1;j>=0;j--)
    {
      var tag = new Array();
      tag["value"] = iElement.options[j].value;
      tag["text"]  = iElement.options[j].text;
      optionTags[index++] = tag;
      if(iElement.options[j].value!=iElement.value)
      {
        iElement.remove(j);
      }
    }
    iElement.optionTags = optionTags;
  }
  else if ((iElement.type=="hidden") ||
            (iElement.type=="password") ||
            (iElement.type=="text") ||
            (iElement.type=="textarea"))
  {
    if(iElement.setReadonlyFlag==true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = true;
    }

    //�¼��洢��oldXXX��
    iElement.oldOnblur = iElement.onblur;
    iElement.onblur = functionDoNothing;

    iElement.oldOndblclick = iElement.ondblclick;
    iElement.ondblclick = functionDoNothing;

    iElement.oldOnfocus = iElement.onfocus;
    iElement.onfocus = functionDoNothing;

    iElement.oldClassName = iElement.className;
    iElement.readOnly = true;
    iElement.className = "readonlyOnly";


    if(iElement.style.width=="")
    {
      switch (iElement.oldClassName)
      {
         case "codecode" :
             iElement.style.width="40px";
             break;
         case "common" :
             iElement.style.width="160px";
             break;
         case "readonly" :
             iElement.style.width="160px";
             break;
         default :
      }
    }

  }
  else if(iElement.type=="button")
  {
    if(iElement.setReadonlyFlag==true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = true;
    }

    if(iElement.name.indexOf("Delete")>-1 || iElement.name.indexOf("Insert")>-1)
    {
      iElement.disabled = true;
    }
  }
  else if(iElement.type=="checkbox")
  {
    setCheckBoxReadonly(iElement,true);
  }
  else if(iElement.type=="radio")
  {
    setRadioReadonly(iElement,true);
  }
}
//���������Ԫ������Ϊֻ����ɶ�д
function setContainerReadonly(Container,Flag)
{
  var i = 0;
  var vFlag = (Flag==null?true:Flag);
  var elements;

  //Input��
  elements = Container.getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(vFlag)
  	  setReadonlyOfElement(elements[i]);
  	else
  	  undoSetReadonlyOfElement(elements[i]);
  }

  //Select��
  elements = Container.getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
    if(vFlag)
  	  setReadonlyOfElement(elements[i]);
  	else
  	  undoSetReadonlyOfElement(elements[i]);
  }


  //Textarea��
  elements = Container.getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
    if(vFlag)
  	  setReadonlyOfElement(elements[i]);
  	else
  	  undoSetReadonlyOfElement(elements[i]);
  }

}

//public
//һ�θ����е�text,textarea����Ϊreadonly,select-one���ֻ������ǰѡ��
//���̲��ֿ���
function setReadonlyOfAllInput()
{
  for(var i=0;i<fm.elements.length;i++)
  {
    setReadonlyOfElement(fm.elements[i]);
  }
}

//public
//���̲��ֿ���,select-one���и����¼���ȡ�� --OK��
function undoSetReadonlyOfElement(iElement)
{
  if(iElement.type=="select-one")
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    var optionTags = iElement.optionTags;
    var currentValue = iElement.value;

    for(var i=iElement.options.length-1;i>=0;i--)
    {
      iElement.remove(i);
    }

    for(var i=optionTags.length-1;i>=0;i--)
    {
      var tag = optionTags[i];
      var op = document.createElement("OPTION");
      op.value = tag.value;
      op.text =  tag.text;
      iElement.add(op);
    }
    iElement.value = currentValue;

  }
  else if ((iElement.type=="hidden") ||
            (iElement.type=="password") ||
            (iElement.type=="text") ||
            (iElement.type=="textarea"))
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    iElement.onblur = iElement.oldOnblur;
    iElement.ondblclick = iElement.oldOndblclick;
    iElement.onfocus = iElement.oldOnfocus;

    iElement.readOnly = false;
    iElement.className = iElement.oldClassName;
  }
  else if(iElement.type=="button")
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    if(iElement.name.indexOf("Delete")>-1 || iElement.name.indexOf("Insert")>-1)
    {
      iElement.disabled = false;
    }
  }
  else if(iElement.type=="checkbox")
  {
    setCheckBoxReadonly(iElement,false);
  }
  else if(iElement.type=="radio")
  {
    setRadioReadonly(iElement,false);
  }

}
//һ�θ����е�text,textarea��readonly����Ϊfalse,select-one�ָ���ʼ����
function undoSetReadonlyOfAllInput()
{
  for(var i=0;i<fm.elements.length;i++)
  {
    undoSetReadonlyOfElement(fm.elements[i]);
  }
}

//�Ӽ�ģʽ������һ������Script(Only for PG)
function insertRowForPG(PageCode,DataPageCode)
{
  insertRow(PageCode,DataPageCode);
  var index = getRowsCount(PageCode);
  setRowColor(DataPageCode,index,BGCOLORI);
  try
  {
    fm.all(PageCode + "_Flag")[index].value="I";
  }
  catch(e)
  {
    errorMessage(PageCode + "_Flag �ֶβ�����");
  }
}


//�Ӽ�ģʽ��ɾ��һ������Script(Only for PG)
function deleteRowForPG(PageCode,DataPageCode,field,intPageDataKeyCount,intRowCount)
{

  var index = getElementOrder(field)-intPageDataKeyCount;
  var flag = "";
  try
  {
    flag = fm.all(PageCode + "_Flag")[index].value;
  }
  catch(e)
  {
    errorMessage(PageCode + "_Flag �ֶβ�����");
    return false;
  }

  if(flag=="I")
  {
    deleteRow(PageCode,field,intPageDataKeyCount,intRowCount);
  }
  else if(flag=="D")
  {
    setRowColor(DataPageCode,index,"");

    var pageFieldsName = getPageFieldsName(PageCode,DataPageCode);

    for(var i=0;i<pageFieldsName.length;i++)
    {
      if(fm.all(pageFieldsName[i])[index].type=="text" || fm.all(pageFieldsName[i])[index].type=="textarea" || fm.all(pageFieldsName[i])[index].type=="password")
      {
        //�ָ�ԭֵ
        fm.all(pageFieldsName[i])[index].value=fm.all(pageFieldsName[i])[index].title;

      }
    }
    fm.all(PageCode + "_Flag")[index].value="";

  }
  else
  {
    fm.all(PageCode + "_Flag")[index].value="D";
    setRowColor(DataPageCode,index,BGCOLORD);
  }
}


//����ͼƬ
function changeImage(image,gif)
{
  image.src='/prpall/common/images/'+gif;
}


//ȡ��
function cancelForm()
{
  window.location="/prpall/common/pub/UIBlank.html";
}


//��ʾ������Ϣ
function errorMessage(strErrMsg)
{
  var strMsg = "ϵͳ��Ϣ:\n\n" + strErrMsg;
  alert(strMsg);
}

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage(field,spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var intIndex = parseInt(getElementOrder(field),10) - 1;
  var span = eval(spanID + "(" + intIndex + ")");
  var strTemp = span.id;
  var strCompare = "Context"; //�Ƚ��ַ������������󼸸��ַ���Context

  if(strTemp.indexOf(strCompare)>-1)
  {
    strTemp = strTemp.substring(strTemp.length - strCompare.length);
  }
  else
  {
    strTemp = "";
  }

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y
  if(strTemp==strCompare)
  {
    ex = ex - 700;
  }
  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}

//��ʾ�����,��span��ȱʡλ����ʾ
function showSubPageAtDefaultPosition(field,spanID)
{
  var intIndex = parseInt(getElementOrder(field),10) - 1;
  var span = eval(spanID + "(" + intIndex + ")");
  span.style.display ='';
}

//���������
function hideSubPage(field,spanID)
{
  var intIndex = parseInt(getElementOrder(field),10) - 1;
  var span = eval(spanID + "(" + intIndex + ")");
  span.style.display ='none';
}

//��ʾspan
//leftMove: span�����ƶ�������,Ĭ��ֵΪ0
function showSpan(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y
  ex = ex - intLeftMove;
  document.all(spanID).style.left = ex;
  document.all(spanID).style.top  = ey;
  document.all(spanID).style.display = '';
}

//����span
function hideSpan(spanID)
{
  document.all(spanID).style.display = 'none';
}

//�õ�table���һ��tbody������������������
function getTableFieldsName(tableId)
{
  var fields = new Array();
  var i;
  var elements;
  var index = 0;

  //�õ�Input�������
  elements = document.all(tableId).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    fields[index] = elements[i].name;
    index++;
  }
  //�õ�Select�������
  elements = document.all(tableId).tBodies.item(0).getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
    fields[index] = elements[i].name;
    index++;
  }
  //�õ�textarea�������
  elements = document.all(tableId).tBodies.item(0).getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
    fields[index] = elements[i].name;
    index++;
  }

  return fields;
}
//����Flag�������ֵ
//mode: 1, ����¼�ı���
//      2, �Ӽ�ģʽ�Ķ��¼����
//      3, ������ģʽ�Ķ��¼����
function setFlagPG(tableId,mode)
{
  var i,j;
  var fields;
  //����¼�ı���
  if(mode==1)
  {
    fm.all(tableId+'_Flag').value = '';
    fields = getTableFieldsName(tableId);
    for(i=0;i<fields.length;i++)
    {
      if(getElementCount(fields[i])>1) //���������һ��
      {
        if( fm.all(fields[i])[0].type=="radio" || fm.all(fields[i])[0].type=="checkbox" )
        {
          for(j=0;j<getElementCount(fields[i]);j++)
          {
            if(fm.all(fields[i])[j].style.display!='none' &&  //������ʾ״̬
               new Boolean(fm.all(fields[i])[j].checked).toString()!=fm.all(fields[i])[j].title  //�¾�״̬��һ��
              )
            {
              fm.all(tableId+'_Flag').value = 'U';
              break;
            }//end if
          }//end for
        }
        else
        {
          errorMessage(tableId+"�����д��ڶ��"+fields[i]+"������");
        }//end if
      }
      else //����ֻ��һ��
      {
        if( fm.all(fields[i]).type=="radio" || fm.all(fields[i]).type=="checkbox" )
        {
          if(fm.all(fields[i]).style.display!='none' &&  //������ʾ״̬
             new Boolean(fm.all(fields[i]).checked).toString()!=fm.all(fields[i]).title  //�¾�״̬��һ��
            )
          {
            fm.all(tableId+'_Flag').value = 'U';
            break;
          }//end if
        }
        else
        {
          if(fm.all(fields[i]).type!='button' &&         //�ǰ�ť
             fm.all(fields[i]).type!='hidden' &&         //��������
             fm.all(fields[i]).style.display!='none' &&  //������ʾ״̬
             fm.all(fields[i]).readOnly!=true &&         //��ֻ����
             fm.all(fields[i]).value!=fm.all(fields[i]).title  //�¾�ֵ��һ��
            )
          {
            fm.all(tableId+'_Flag').value = 'U';
            break;
          }//end if
        }//end if
      }//end if
    }//end for
  }
  //�Ӽ�ģʽ�Ķ��¼����
  else if(mode==2)
  {
    fields = getTableFieldsName(tableId+'_Data');
    var len = document.all(tableId).tBodies.item(0).rows.length;
    for(i=1;i<=len;i++)
    {
      if(fm.all(tableId+'_Flag')[i].value!='' &&
         fm.all(tableId+'_Flag')[i].value!='U'
        )
      {
        continue;
      }

      fm.all(tableId+'_Flag')[i].value = '';
      for(j=0;j<fields.length;j++)
      {
        if(fm.all(fields[j])[i].type=='checkbox' ) //checkbox������
        {
          if(fm.all(fields[j])[i].style.display!='none' &&  //������ʾ״̬
             new Boolean(fm.all(fields[j])[i].checked).toString()!=fm.all(fields[j])[i].title  //�¾�״̬��һ��
            )
          {
            fm.all(tableId+'_Flag')[i].value = 'U';
            break;
          }
        }
        else if( fm.all(fields[j])[i].type!='button' &&         //�ǰ�ť
                 fm.all(fields[j])[i].type!='hidden' &&         //��������
                 fm.all(fields[j])[i].style.display!='none' &&  //������ʾ״̬
                 fm.all(fields[j])[i].readOnly!=true &&         //��ֻ����
                 fm.all(fields[j])[i].value!=fm.all(fields[j])[i].title  //�¾�ֵ��һ��
          )
        {
          fm.all(tableId+'_Flag')[i].value = 'U';
          break;
        }//end if
      }//end for
    }//end for
  }
  //������ģʽ�Ķ��¼����
  else if(mode==3)
  {
    var onePageData = getPageData(tableId);
    fields = onePageData.field;
    for(i=0;i<onePageData.length;i++)
    {
      var onePageRowData = onePageData[i];

      if(onePageRowData[tableId+'_Flag'].value!='' &&
         onePageRowData[tableId+'_Flag'].value!='U'
        )
      {
        continue;
      }

      onePageRowData[tableId+'_Flag'].value = '';
      for(j=0;j<fields.length;j++)
      {
        if(fm.all(fields[j]).type!='button' &&         //�ǰ�ť
           fm.all(fields[j]).type!='hidden' &&         //��������
           fm.all(fields[j]).style.display!='none' &&  //������ʾ״̬
           fm.all(fields[j]).readOnly!=true &&         //��ֻ����
           onePageRowData[fields[j]].value!=onePageRowData[fields[j]].title  //�¾�ֵ��һ��
          )
        {
          onePageRowData[tableId+'_Flag'].value = 'U';
          if(onePageData.currentIndex==i)
            fm.all(tableId+'_Flag').value = 'U';
          break;
        }
      }
    }
  }

}


//�鿴�������
function visitHandelText(vCaseidNo)
{
  var newWindow = window.open("/pages/VisitHandleText.jsp?CaseidNo="+vCaseidNo,"vistText","width=600,height=200,top=150,left=100,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
  newWindow.focus();
  return newWindow;
}



//��ʾ��������
function showCollectItem()
{
  var newWindow = window.open("/prpall/common/pub/UIItemCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}

//��ʾ���ջ�������
function showCollectItemC()
{
  var newWindow = window.open("/prpall/common/pub/UIItemCCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}

//��ʾ���ջ�������
function showCollectItemY()
{
  var newWindow = window.open("/prpall/common/pub/UIItemYCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}


//��ʾ���ܸ�����
function showCollectItemApd()
{
  var newWindow = window.open("/prpall/common/pub/UIItemApdCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}


//��ʾ���ջ��ܸ�����
function showCollectItemApdC()
{
  var newWindow = window.open("/prpall/common/pub/UIItemApdCollectC.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}


//��ʾ���ұ����
function showCollectCurrency()
{
  var newWindow = window.open("/prpall/common/pub/UICurrencyCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}


//��ʾ���仯������
function showCollectChange()
{
  var newWindow = window.open("/prpall/common/pub/UIChangeCollect.html","new","width=400,height=220,top=200,left=200,scrollbars=yes");
  newWindow.focus();
  return newWindow;
}


//��span����ʾ������
function showPage(img,spanID)
{
  if(spanID.style.display=="")
  {
    //�ر�
    spanID.style.display="none";
    img.src="/prpall/common/images/butCollapse.gif";
  }
  else
  {
    //��
    spanID.style.display="";
    img.src="/prpall/common/images/butExpand.gif";
  }
}

//��span����ʾonly
function showPageOnly(img,spanID)
{
  //��
  spanID.style.display="";
  img.src="/prpall/common/images/butExpand.gif";
}


//������Ѱ��ұ���ܣ�
//��������������ұ𣬱�����ѵ�ԭʼ����(Currency,Amount,Premium)
//����ֵ�����ұ���ܵıұ𣬱�����ѵ�����
function collectByCurrency(arrayFee)
{
  var arrayReturn = new Array();
  var i = 0;
  var j = 0;
  for(i=0;i<arrayFee.length;i++)
  {
    for(j=i+1;j<arrayFee.length;j++)
    {
      if(trim(arrayFee[j].Currency)==trim(arrayFee[i].Currency))
      {
        arrayFee[i].Amount  = parseFloat(arrayFee[i].Amount) + parseFloat(arrayFee[j].Amount);
        arrayFee[j].Amount  = 0;
        arrayFee[i].Premium = parseFloat(arrayFee[i].Premium) + parseFloat(arrayFee[j].Premium);
        arrayFee[j].Premium = 0;
      }
    }
  }

  j=0;
  for(i=0;i<arrayFee.length;i++)
  {
    if(arrayFee[i].Amount == 0 && arrayFee[i].Premium == 0)
    {
      continue;
    }
    arrayReturn[j] = arrayFee[i];
    j++;
  }

  return arrayReturn;
}


//������Ѱ��ұ𡢱�������־���ܣ�
//��������������ұ𣬱�����ѵ�ԭʼ����(Currency,Amount,Premium)
//����ֵ�����ұ𡢱�������־���ܵıұ𣬱�����ѵ�����
function collectByCurrencyAndCalculateFlag(arrayFee)
{
  var arrayReturn = new Array();
  var i = 0;
  var j = 0;
  var blnExist = false;
  for(i=0;i<arrayFee.length;i++)
  {
    blnExist = false;
    for(j=0;j<arrayReturn.length;j++)
    {
      if(arrayFee[i].Currency==arrayReturn[j].Currency)
      {
        blnExist = true;
        break;
      }
    }
    if(blnExist)
    {
      arrayReturn[j].Premium = arrayReturn[j].Premium + arrayFee[i].Premium;
      if(arrayFee[i].CalculateFlag=="Y")
      {
        arrayReturn[j].Amount = arrayReturn[j].Amount + arrayFee[i].Amount;
        arrayReturn[j].CalculateFlag = "Y";
      }
    }
    else
    {
      if(arrayFee[i].CalculateFlag!="Y") arrayFee[i].Amount = 0;
      arrayReturn[arrayReturn.length] = arrayFee[i];
    }
  }

  return arrayReturn;
}


////���ұ���ܺ���
//var arrayCollect = new Array();    //����������
//
////���� (����,�ұ�����,��������,��������)
//function collectFee(intNum,CN,Amt,Prm )
//{
//  var arrayCollectOne ;
//  for(i=0;i<intNum;i++)
//  {
//    var strCN      = fm.all(CN)[i].value;
//    var strAmount  = fm.all(Amt)[i].value;
//    var strPremium = fm.all(Prm)[i].value;
//    var existFlag  = false;
//
//    if(!isNumeric(strAmount))
//      strAmount=0;
//    else
//      strAmount=eval(strAmount);
//    if(!isNumeric(strPremium))
//      strPremium=0;
//    else
//      strPremium=eval(strPremium);
//
//    for(j=0;j<arrayCollect.length;j++)
//    {
//      if( arrayCollect[j]["CN"] == strCN )
//      {
//        existFlag = true;
//        break;
//      }
//    }
//    if(!existFlag)
//    {
//      arrayCollectOne = new Array(); //һ��������
//      arrayCollectOne["CN"] = strCN;
//      arrayCollectOne["Amount"] = strAmount;
//      arrayCollectOne["Premium"] = strPremium;
//      arrayCollect[j] = arrayCollectOne;
//    }
//    else
//    {
//      arrayCollect[j]["Amount"] = arrayCollect[j]["Amount"] + strAmount ;
//      arrayCollect[j]["Premium"] = arrayCollect[j]["Premium"] + strPremium ;
//    }
//  }
//}

//
////����***���븳ֵ --����ά��ģ��ר��onblur=setNewCode(this)
//function setNewCode(field)
//{
//  if( trim(fm.all("new"+field.name).value)=="" )
//  {
//    fm.all("new"+field.name).value = field.value;
//  }
//}



//�õ����ڷ��ʱ�
function getMonthRate(intMonthNum)
{
  var mrate = new Array(0,10,20,30,40,50,60,70,80,85,90,95,100);
  var floatReturn = Math.floor(intMonthNum/12)+ mrate[intMonthNum%12]/100;
  return floatReturn;
}

//������ڷ��ʺ���
function getShortRate(strMode,strStartDate,strEndDate)
{
  var startDate = new Date(replace(strStartDate,"-","/"));
  var endDate = new Date(replace(strEndDate,"-","/"));
  var shortRate = 0;
  if(parseInt(strMode,10)==1 )  //�±���
  {
    shortRate = getMonthRate(dateDiff(startDate,endDate,"M"))*100;
  }
  else if(parseInt(strMode,10)==2 )  //�ձ���
  {
    shortRate = dateDiff(startDate,endDate,"D")*100/365;
  }
  else
  {
    shortRate = 100;
  }
  return shortRate;
}
//������ڷ��ʺ���
function getShortRate(strMode,strStartDate,strStartHour,strEndDate,strEndHour)
{
  var shortRate = 0;
  var strRiskCode = "PUB";
  if(parseInt(strMode,10)==1 )  //�±���
  {
    try{ strRiskCode = fm.RiskCode.value; }catch(e){}
    return getShortRateMonth(strStartDate,strEndDate,strRiskCode);
  }
  else if(parseInt(strMode,10)==2 )  //�ձ���
  {
    return getShortRateDay(strStartDate,strStartHour,strEndDate,strEndHour);
  }
  else
  {
    shortRate = 100;
  }
  return shortRate;
}
//���±���������ڷ��ʺ���
function getShortRateMonth(strStartDate,strEndDate,strRiskCode)
{
  var startDate = new Date(replace(strStartDate,"-","/"));
  var endDate   = new Date(replace(strEndDate,"-","/"));

  var monthCount = dateDiff(startDate,endDate,"M");
  var shortRate  = getMonthRate(monthCount,strRiskCode) * 100;
  return shortRate;
}
//���ձ���������ڷ��ʺ���
function getShortRateDay(strStartDate,strStartHour,strEndDate,strEndHour)
{
  var startDate = new Date(replace(strStartDate,"-","/"));
  var endDate   = new Date(replace(strEndDate,"-","/"));
  var dayCount  = dateDiff(startDate,endDate,"D");
  var shortRate = 0;
  if(strStartHour=="0" && strEndHour=="0")
  {
    dayCount = dayCount -1;
  }

  if(strStartHour=="24" && strEndHour=="24")
  {
    dayCount = dayCount -1;
  }

  if(strStartHour=="24" && strEndHour=="0")
  {
    dayCount = dayCount -2;
  }

  shortRate = dayCount/365*100;
  return shortRate;
}



//�ӱ�(����)
function incAmount(vNewAmount,vOldAmount,vNewRate,vOldRate,vNewDiscount,vOldDiscount,shortRateValue)
{
  var Dpremium =
      parseFloat(vNewAmount) * parseFloat(vNewRate) * parseFloat(vNewDiscount) * parseFloat(shortRateValue)
    - parseFloat(vOldAmount) * parseFloat(vOldRate) * parseFloat(vOldDiscount) * parseFloat(shortRateValue);

  return Dpremium;
}


//����(����)
function decAmount(vNewAmount,vOldAmount,vNewRate,vOldRate,vNewDiscount,vOldDiscount,vOverShortRate,vShortRate)
{
  var Dpremium =
      ((parseFloat(vNewAmount)-parseFloat(vOldAmount))* parseFloat(vOldRate) * parseFloat(vOldDiscount)
      + parseFloat(vOldAmount)*(parseFloat(vNewRate) * parseFloat(vNewDiscount)
      - parseFloat(vOldRate) * parseFloat(vOldDiscount)
      ))
      *(parseFloat(vShortRate)-parseFloat(vOverShortRate));

  return Dpremium;
}


//�ӱ�(��������)
function incTime(vAmount,vRate,vDiscount,vShortRate)
{
  var Dpremium =
    parseFloat(vAmount) * parseFloat(vRate) * parseFloat(vDiscount) * parseFloat(vShortRate);
  return Dpremium;
}


//����(��������)
function decTime(vAmount,vRate,vDiscount,vOldShortRate,vNewShortRate)
{
  var Dpremium =
    parseFloat(vAmount) * parseFloat(vRate) * parseFloat(vDiscount)
    * ( parseFloat(vNewShortRate) - parseFloat(vOldShortRate) );
  return Dpremium;
}


//���ĵļ��㱣��(����仯ʱ)
function calAmountPremium(field,ext)
{
  var fieldname=field.name;
  var i = 0;
  var findex=0;

  //�õ�������
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  //�õ���ֵ
  var amountValue    = fm.all("Amount"+ext)[findex].value;         //�±���
  var rateValue      = fm.all("Rate"+ext)[findex].value;           //�·���
  var discountValue  = fm.all("Discount"+ext)[findex].value;       //�ۿ���
  var vShortRateFlag = fm.all("ShortRateFlag"+ext)[findex].value;  //���ڷ��ʷ�ʽ

  //����ֵ�ĺϷ���
  if( !isNumeric(amountValue) || !isNumeric(rateValue)
      || !isNumeric(discountValue)) return 0;
  if( eval(amountValue)<0 || eval(rateValue)<0
      || eval(discountValue)<0) return 0;

  //�����ı�ɾ�����±��0����
  if(ext=="Main" || ext=="Sub")
  {
    if(findex<fm.all(fieldname).length && (fm.all("Itemkind"+ext+"_Flag")[findex].value=="D"))
    {
      amountValue="0";
    }
  }
  else if(ext=="Spe")
  {
    if(findex<fm.all(fieldname).length && fm.all(SpecialFlag)[findex].value=="D")
      amountValue="0";
  }

  if(vShortRateFlag=="1")
    vShortRateFlag = "M";
  else
    vShortRateFlag = "D";

  //ԭֵ����
  var pv = 0;             //����
  var dpv = 0;            //���ѱ仯��
  var vOldAmount = 0;     //ԭ����
  var vOldRate = 0 ;      //ԭ����
  var vShortRate = 0;     //ԭ���ڷ���
  var vOldDiscount = 0;   //ԭ�ۿ���
  var vOverShortRate = 0; //�������ζ��ڷ���
  var shortRateValue = 0; //δ�˶��ڷ���

  if( findex < fm.all(fieldname).length && (fm.all("Itemkind"+ext+"_Flag")[findex].value!="I")) //�޸ı��
  {
    pv = fm.all("Premium"+ext)[findex].title;             //ԭ����
    vOldAmount = fm.all("Amount"+ext)[findex].title;      //ԭ����
    vOldRate   = fm.all("Rate"+ext)[findex].title;        //ԭ����
    vOldDiscount = fm.all("Discount"+ext)[findex].title;  //ԭ�ۿ���
  }
  else
  {
    pv = 0;         //ԭ����
    vOldAmount = 0; //ԭ����
    vOldRate   = 0; //ԭ����
    vOldDiscount = 0;
  }

  //����
  var sdate,edate,pdate,pprevdate;
  var tmpd = fm.ValidDate.value.split("/");   //��Ч����
  pdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);

  try
  {  //��PolicySort������
    if( fm.PolicySort.value=="8" )//�Է��ڽ��㵥���ĵĴ���
    {
      tmpd = fm.FQStartDate.value.split("/");
      sdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
      tmpd = fm.FQEndDate.value.split("/");
      edate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
    }
    else //��ͨ�������ĵĴ���
    {
      sdate = new Date(fm.StartDate.value );
      edate = new Date(fm.EndDate.value );
    }
  }
  catch(ex)
  {  //û��PolicySort������
    sdate = new Date(fm.StartDate.value );
    edate = new Date(fm.EndDate.value );
  }

  pprevdate = new Date(pdate.getYear(),pdate.getMonth(),pdate.getDate()-1);

  //δ�����ζ��ڷ���
  if( vShortRateFlag=="M" )
    shortRateValue = monthToRate(dateDiff(pdate,edate,vShortRateFlag));
  else
    shortRateValue = dateDiff(pdate,edate,vShortRateFlag)/365;

  //ԭ���ڷ���
  if( vShortRateFlag=="M" )
    vShortRate = monthToRate(dateDiff(sdate,edate,vShortRateFlag));
  else
    vShortRate = dateDiff(sdate,edate,vShortRateFlag)/365;

  //�������ζ��ڷ���
  if( vShortRateFlag=="M" )
    vOverShortRate = monthToRate(dateDiff(sdate,pprevdate,vShortRateFlag));
  else
    vOverShortRate = dateDiff(sdate,pprevdate,vShortRateFlag)/365;

  if( vOldAmount==0 || vOldAmount<=parseFloat(amountValue) )
  {
    dpv = incAmount( parseFloat(amountValue),
               vOldAmount,
               parseFloat(rateValue)/1000,
               parseFloat(vOldRate)/1000,
               discountValue/100,
               vOldDiscount/100,
               shortRateValue);        //δ�˶��ڷ���
  }
  else
  {
    dpv = decAmount( parseFloat(amountValue),
               vOldAmount,
               parseFloat(rateValue)/1000,
               parseFloat(vOldRate)/1000,
               discountValue/100,
               vOldDiscount/100,
               vOverShortRate,         //���˶��ڷ���
               vShortRate);            //ԭ���ڷ���
  }

  pv = parseFloat(pv) + dpv;
  pv = pointTwo(mathRound(pv));
  fm.all("Premium"+ext)[findex].value= pv;
  fm.all("Premium"+ext)[findex].onchange();

  return pv;
}


//���ĵļ��㱣��(�������ޱ仯ʱ)
function calTimePremium(fieldname,ext)
{
  var i;
  var vShortRate = 0;     //ԭ���ڷ���(��-ԭ�ձ�)
  var vOverShortRate = 0; //�������ζ��ڷ���(��-���ձ�)
  var shortRateValue = 0; //δ�˶��ڷ���(ԭ�ձ�-���ձ�)

  //����
  var sdate,edate,pdate,enextdate;

  try
  {
    if( fm.PolicySort.value=="8" )//�Է��ڽ��㵥���ĵĴ���
    {
      tmpd = fm.FQEndDate.value.split("/");
      if(tmpd.length!=3 || !isNumeric(tmpd[0]) || !isNumeric(tmpd[1]) || !isNumeric(tmpd[2]) ) return;
      pdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
      tmpd = fm.FQStartDate.value.split("/");
      sdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
      tmpd = oldFQEndDate.split("/");
      edate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
    }
    else //��ͨ�������ĵĴ���
    {
      pdate = new Date(fm.EndDate.value);    //���ĺ���ձ�����
      sdate = new Date(fm.StartDate.value);  //������
      edate = new Date(fm.EndDate.title);    //����ǰ���ձ�����
    }
  }
  catch(ex)
  {
      pdate = new Date(fm.EndDate.value);
      sdate = new Date(fm.StartDate.value);
      edate = new Date(fm.EndDate.title);
  }
  enextdate = new Date(edate.getYear(),edate.getMonth(),edate.getDate()+1);

  //�����������
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    //�õ���ֵ
    var amountValue    = fm.all("Amount"+ext)       [i].value;  //����
    var rateValue      = fm.all("Rate"+ext)         [i].value;  //����
    var discountValue  = fm.all("Discount"+ext)     [i].value;  //�ۿ���
    var vShortRateFlag = fm.all("ShortRateFlag"+ext)[i].value;  //���ڷ��ʷ�ʽ

    //����ֵ�ĺϷ���
    if( !isNumeric(amountValue) || !isNumeric(rateValue)
        || !isNumeric(discountValue) ) continue;
    if( eval(amountValue)<0 || eval(rateValue)<0
        || eval(discountValue)<0 ) continue;

    //���ڷ��ʷ�ʽ
    if(vShortRateFlag=="1")
      vShortRateFlag = "M";
    else
      vShortRateFlag = "D";

    //δ�����ζ��ڷ��� (�������ڷ���)
    if( vShortRateFlag=="M" )
      shortRateValue = monthToRate(dateDiff(enextdate,pdate,vShortRateFlag));
    else
      shortRateValue = dateDiff(edate,pdate,vShortRateFlag)/365;

    //ԭ���ڷ���
    if( vShortRateFlag=="M" )
      vShortRate = monthToRate(dateDiff(sdate,edate,vShortRateFlag));
    else
      vShortRate = dateDiff(sdate,edate,vShortRateFlag)/365;

    //�������ζ��ڷ���(�¶��ڷ���)
    if( vShortRateFlag=="M" )
      vOverShortRate = monthToRate(dateDiff(sdate,pdate,vShortRateFlag));
    else
      vOverShortRate = dateDiff(sdate,pdate,vShortRateFlag)/365;

    //���㱣��
    var pv = fm.all("Premium"+ext)[i].title; //ԭ����

    if( isNaN(parseFloat(pv)) ) //�����
    {
      fm.all("Premium"+ext)[i].value = "";
      fm.all("Premium"+ext)[i].onchange();
      return ;
    }

    var dpv = 0;            //���ѱ仯��
    if( edate.getTime()<pdate.getTime() )
    {
      dpv = incTime(parseFloat(amountValue),
                    parseFloat(rateValue)/1000,
                    discountValue/100,
                    shortRateValue);
    }
    else
    {
      dpv = decTime(parseFloat(amountValue),
                    parseFloat(rateValue)/1000,
                    discountValue/100,
                    vShortRate,
                    vOverShortRate);
    }

    pv = parseFloat(pv) + dpv;   //�±���=ԭ����+ ���ѱ仯��
    pv = pointTwo(mathRound(pv));
    fm.all("Premium"+ext)[i].value= pv;
    fm.all("Premium"+ext)[i].onchange();
    fm.all("ShortRate"+ext)[i].value= point(mathRound(vOverShortRate*100),4);
  }
}


//���ĵļ��㵥����ı���(�������ޱ仯ʱ������ǰУ����)
function calTimeSinglePremium(field,ext)
{
  var i;
  var findex=0;
  var vShortRate = 0;     //ԭ���ڷ���(��-ԭ�ձ�)
  var vOverShortRate = 0; //�������ζ��ڷ���(��-���ձ�)
  var shortRateValue = 0; //δ�˶��ڷ���(ԭ�ձ�-���ձ�)

  //����
  var sdate,edate,pdate,enextdate;

  var fieldname=field.name;

  //�õ�������
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  try
  {
    if( fm.PolicySort.value=="8" )//�Է��ڽ��㵥���ĵĴ���
    {
      tmpd = fm.FQEndDate.value.split("/");
      if(tmpd.length!=3 || !isNumeric(tmpd[0]) || !isNumeric(tmpd[1]) || !isNumeric(tmpd[2]) ) return;
      pdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
      tmpd = fm.FQStartDate.value.split("/");
      sdate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
      tmpd = oldFQEndDate.split("/");
      edate = new Date(tmpd[0],parseInt(tmpd[1],10)-1,tmpd[2]);
    }
    else //��ͨ�������ĵĴ���
    {
      pdate = new Date(fm.EndDate.value);    //���ĺ���ձ�����
      sdate = new Date(fm.StartDate.value);  //������
      edate = new Date(fm.EndDate.title);    //����ǰ���ձ�����
    }
  }
  catch(ex)
  {
      pdate = new Date(fm.EndDate.value);
      sdate = new Date(fm.StartDate.value);
      edate = new Date(fm.EndDate.title);
  }
  enextdate = new Date(edate.getYear(),edate.getMonth(),edate.getDate()+1);

  //�õ�ֵ
  var amountValue    = fm.all("Amount"+ext)       [findex].value;  //����
  var rateValue      = fm.all("Rate"+ext)         [findex].value;  //����
  var discountValue  = fm.all("Discount"+ext)[findex].value;       //�ۿ���
  var vShortRateFlag = fm.all("ShortRateFlag"+ext)[findex].value;  //���ڷ��ʷ�ʽ

  //����ֵ�ĺϷ���
  if( !isNumeric(amountValue) || !isNumeric(rateValue)
      || !isNumeric(discountValue) ) return 0;
  if( eval(amountValue)<0 || eval(rateValue)<0
      || eval(discountValue)<0 ) return 0;

  //���ڷ��ʷ�ʽ
  if(vShortRateFlag=="1")
    vShortRateFlag = "M";
  else
    vShortRateFlag = "D";

  //δ�����ζ��ڷ���
  if( vShortRateFlag=="M" )
    shortRateValue = monthToRate(dateDiff(enextdate,pdate,vShortRateFlag));
  else
    shortRateValue = dateDiff(edate,pdate,vShortRateFlag)/365;

  //ԭ���ڷ���
  if( vShortRateFlag=="M" )
    vShortRate = monthToRate(dateDiff(sdate,edate,vShortRateFlag));
  else
    vShortRate = dateDiff(sdate,edate,vShortRateFlag)/365;

  //�������ζ��ڷ���
  if( vShortRateFlag=="M" )
    vOverShortRate = monthToRate(dateDiff(sdate,pdate,vShortRateFlag));
  else
    vOverShortRate = dateDiff(sdate,pdate,vShortRateFlag)/365;

  //���㱣��
  var pv = fm.all("Premium"+ext)[findex].title; //ԭ����

  if( isNaN(parseFloat(pv)) ) //�����
  {
    fm.all("Premium"+ext)[findex].value = "";
    fm.all("Premium"+ext)[findex].onchange();
    return ;
  }

  var dpv = 0;            //���ѱ仯��
  if( edate.getTime()<pdate.getTime() )
  {
    dpv = incTime(parseFloat(amountValue),
                  parseFloat(rateValue)/1000,
                  discountValue/100,
                  shortRateValue);
  }
  else
  {
    dpv = decTime(parseFloat(amountValue),
                  parseFloat(rateValue)/1000,
                  discountValue/100,
                  vShortRate,
                  vOverShortRate);
  }

  pv = parseFloat(pv) + dpv;   //�±���=ԭ����+ ���ѱ仯��
  pv = pointTwo(mathRound(pv));
  fm.all("Premium"+ext)[findex].value= pv;
  fm.all("Premium"+ext)[findex].onchange();
  fm.all("ShortRate"+ext)[findex].value= point(mathRound(vOverShortRate*100),4);

  return pv;
}

//
//  ��ѯ
//
//���������Ƿ������ڵ�У��(���ڸ�ʽxxxx/xx/xx)
function isDateI(date)
{
  var strValue;
  strValue=date.split("/");

  if(strValue.length!=3) return false;
  if(!isInteger(strValue[0]) || !isInteger(strValue[1]) || !isInteger(strValue[2]) ) return false;

  var intYear=eval(strValue[0]);
  var intMonth=eval(strValue[1]);
  var intDay=eval(strValue[2]);

  if( intYear<0 || intYear>9999 || intMonth<0 || intMonth>12 || intDay<0 || intDay>31 ) return false;
  return true;
}

//�Ƚ����������ַ���(���ڸ�ʽxxxx/xx/xx)
// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�2
function compareDateI(date1,date2)
{
  var strValue=date1.split("/");
  var date1Temp=new Date(strValue[0],strValue[1],strValue[2]);

  strValue=date2.split("/");
  var date2Temp=new Date(strValue[0],strValue[1],strValue[2]);

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else
    return 2;
}

//���������Ƿ��������ѯ��ʽ�����ڵ�У��(���ڸ�ʽxxxx/xx/xx)
function isQueryDate(sign,date)
{
  var strValue;

  //������ж�
  if (sign==":")
  {
    strValue=date.split(":");
    if (strValue.length!=2) return false;
    if (!isDateI(strValue[0])) return false;
    if (!isDateI(strValue[1])) return false;
    if (compareDateI(strValue[0],strValue[1])==1) return false;
  }
  //��һ���ڵ��ж�
  else
  {
    return isDateI(date);
  }
  return true;
}

//���������Ƿ��������ѯ��ʽ��������У��integer
function isQueryInteger(sign,integer)
{
  var strValue;

  //������ж�
  if (sign==":")
  {
    strValue=integer.split(":");
    if (strValue.length!=2) return false;
    if (!isInteger(strValue[0])) return false;
    if (!isInteger(strValue[1])) return false;
    if (strValue[0]>strValue[1]) return false;
  }
  //��һ���ڵ��ж�
  else
  {
    return isInteger(integer);
  }
  return true;
}

//���������Ƿ��������ѯ��ʽ�����ֵ�У��
function isQueryNum(sign,num)
{
  var strValue;

  //������ж�
  if (sign==":")
  {
    strValue=num.split(":");
    if (strValue.length!=2) return false;
    if (!isNumeric(strValue[0])) return false;
    if (!isNumeric(strValue[1])) return false;
    if (strValue[0]<strValue[1]) return false;
  }
  //��һ���ڵ��ж�
  else
  {
    return isNumeric(num);
  }
  return true;
}

//Сʱ�ж�
function checkHour(field)
{
    if (field.value<0||field.value>24)
    {
    errorMessage("ʱ���ʽ���벻�Ϸ�");
    field.focus();
    return false;
    }
}



//�Ʋ��˶������
function collectProp()
{
  openWindow("/prpall/temp/common/lp/UILpropCollect.jsp","CollectProp");
}
//��Ա�˶������
function collectPerson()
{
  openWindow("/prpall/temp/common/lp/UILpersonCollect.jsp","CollectPerson");
}
//�Ʋ��⸶�嵥����
function collectLoss()
{
  openWindow("/prpall/0501/lp/compensate/UIL0501lossCollect.jsp","CollectLoss");
}
//��Ա�⸶�嵥����
function collectPersonLoss()
{
  openWindow("/prpall/temp/common/lp/UILpersonLossCollect.jsp","CollectPersonLoss");
}


//��ʾ��ͬ��Ϣ
function ShowContractNo(strBizType,strContractNo)
{
	if(strContractNo == null || trim(strContractNo).length < 21)
	{
		alert("û���ṩ��Ч�ĺ�ͬ��!");
		return;
	}
	var strURL = "/prpall/0501/tbcb/UIPrpslPoli0501MotorcadeShow.jsp?SHOWTYPE=SHOW&" + "BIZTYPE=" + strBizType +"&ContractNo="+strContractNo;
  openWindow(strURL,"strContractNo");

}


//����
function relate(strPolicyNo)
{
		if(strPolicyNo == null || trim(strPolicyNo).length < 20)
		{
		 	alert("û���ṩ��Ч�ı����ţ�");
		 	return;
		}

  var strURL = "/prpall/common/pub/UIRelate.jsp?PolicyNo="+strPolicyNo;
  var newWindow = window.open(strURL,"Relate",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
}

//����
function relateProposalNo(strProposalNo)
{
		if(strProposalNo == null || trim(strProposalNo).length < 20)
		{
		 	alert("û���ṩ��Ч��Ͷ�����ţ�");
		 	return;
		}

  var strURL = "/prpall/common/pub/UIRelateProposalNo.jsp?ProposalNo="+strProposalNo;
  var newWindow = window.open(strURL,"Relate",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
}

//����һ��field����,����һ��field����ֵ
function newFieldPG(value,title,tag,flag)
{
	var field = new Array();
	field.value = value;
	field.title = title;

	if(flag=="I")
  	field.backgroundColor = BGCOLORI;
  else if(flag=="D")
    field.backgroundColor = BGCOLORD;
  else if(flag=="U" && value!=title)
    field.backgroundColor = BGCOLORU;
  else
    field.backgroundColor = "";

	field.tag   = tag;
	return field;
}


//������ʾʱ������һ�е���ɫ
function setRowColorPG(DataPageCode,index,flag)
{
	var i = 0;
	var name = "";
  var elements;
  var color = "";
  if(flag=="I")
  {
    setRowColor(DataPageCode,index,BGCOLORI);
    return ;
  }
  else if(flag=="D")
  {
    setRowColor(DataPageCode,index,BGCOLORD);
    return ;
  }
  else if(trim(flag)=="")
  {
    return ;
  }

  //--������flag=="U"�����
  color = BGCOLORU;

  //�õ�Input�������
  elements = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].type=="button") continue;
  	if(fm.all(elements[i].name)[index].value!=fm.all(elements[i].name)[index].title)
      fm.all(elements[i].name)[index].style.backgroundColor = color;
  }
  //�õ�Select�������
  elements = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("select");
  for(i=0;i<elements.length;i++)
  {
  	if(fm.all(elements[i].name)[index].value!=fm.all(elements[i].name)[index].title)
      fm.all(elements[i].name)[index].style.backgroundColor = color;
  }
  //�õ�textarea�������
  elements = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("textarea");
  for(i=0;i<elements.length;i++)
  {
  	if(fm.all(elements[i].name)[index].value!=fm.all(elements[i].name)[index].title)
      fm.all(elements[i].name)[index].style.backgroundColor = color;
  }

}

//�����������ͬԪ�ص�λ��
function getSameElementOrder(container,elementTagName,elementName,elementValue)
{
  var elements = container.getElementsByTagName(elementTagName);
  for(var i=0;i<elements.length;i++)
  {
    if(elements[i].name==elementName)
    {
      if(elements[i].value==elementValue)
      {
        return getElementOrder(elements[i],container.document.fm);
      }
    }//end if
  }//end for
  return -1;
}//end function

//Ԫ���������������λ��
function getElementOrderFromContainer(container,elementTagName,field)
{
  var index = -1;
  var elements = container.getElementsByTagName(elementTagName);
  for(var i=0;i<elements.length;i++)
  {
    if(elements[i].name==field.name)
    {
      index++;
      if(elements[i]==field) return index;
    }//end if
  }//end for
  return -1;
}

//��ť�����¼��������������ʾ
function buttonOnClick(Field,strCodeType,intCodeCodeOffset,intCodeNameOffset,strSubPageCode)
{
  var intElementIndex=getElementIndex(Field);
  var strCodeCode = trim(fm.elements[intElementIndex + intCodeCodeOffset].value);
  var strContext  = trim(fm.elements[intElementIndex + intCodeNameOffset].value);

  var strCodeTypeTemp = "";
  if(strCodeType.indexOf("Context")>-1)
  {
    strCodeTypeTemp = strCodeType.substring(0,strCodeType.indexOf("Context"));
  }
  else
  {
    return;
  }

  if(strContext=="")
  {
    strContext = ""; //����strCodeTypeTemp��strCodeCodeȡ����
    fm.elements[intElementIndex + intCodeNameOffset].value = strContext;
    showSubPage(Field,strSubPageCode);
  }

  showSubPage(Field,strSubPageCode);
}


/**
 @Author     : �й������Ŀ��
 @description �鿴�˱���Ϣ
 @param       ��
 @return      ��
 */
function viewTrace(businessNo)
{
	if(businessNo=="")
	{
		errorMessage("û�к˱���Ϣ!");
		return ;
	}
	//fm.target = "fraSubmit";
	//fm.action = "/undwrt/CommonViewTrace.do?BusinessNo=" + businessNo;
    //fm.method="post";
	//fm.submit();
 	//var strURL="/undwrt/common/CommonTraceInfo.jsp?BusinessNo=" + businessNo;
 	//window.open(strURL,'�˱���Ϣ','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');


	var submitStr = fm.undwrtUrl.value;//��Ӧ�ò���ʽ �Ի��� 2008-02-29
	submitStr += "/CommonViewTrace.do?BusinessNo=" + businessNo;
	//alert("------submitStr-------"+submitStr);
	window.open(submitStr,'�˱���Ϣ','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
}

//��ȡ��������(�Ʋ�¬����20030407)
//strQueryString������ʽ�ǣ�����1=ֵ1&����2=ֵ2
function getClauseContext(strQueryString)
{
  var ClauseURL = "/prpall/common/pub/UIClauseGet.jsp";
  var strURL = ClauseURL + "?" + strQueryString;
  var vXmlText = getResponseXmlText(strURL);
  //�ص�ͷβ�ַ�[]
  if(vXmlText.length>=2)
    return vXmlText.substring(1,vXmlText.length-1);
  else
    return "";
}

//ʹ��xmlhttp����ҳ�棬����ȡ����(�Ʋ�¬����20030407)
function getResponseXmlText(strURL)
{
  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  objXmlHttp.Open("POST",strURL,false);
  objXmlHttp.setRequestHeader("Content-type","text/xml");
  objXmlHttp.Send("");
  if(objXmlHttp.status==200)
  {
    return objXmlHttp.responseXML.text;
  }
  else if(objXmlHttp.status==404)
  {
    alert("�Ҳ���ҳ�棺"+ strURL);
    return "";
  }
  else
  {
    alert("����"+ strURL +"����������ţ�"+objXmlHttp.status);
    return "";
  }
}

//ͨ��������ź���(�Ʋ�¬����20030407)
//���� serialNoElements ���������
//     startNo ��ʼ���
function resetSerialNumber(serialNoElements,startNo)
{
  for(var i=0;i<serialNoElements.length;i++)
    serialNoElements[i].value = startNo + i;
}


//add begin by liuyang 2003/10/14
//�뿪��ʱ������У��Decimal
function checkDecimal2(field,p,s,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  if(strValue.length>0 && strValue.charAt(0)=="-")
    strValue = strValue.substring(1);

  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;

  if(!isNumeric(strValue))
  {
    errorMessage("������Ϸ�������");
    field.focus();
    field.select();
    return false;
  }
  p = parseInt(p,10);
  s = parseInt(s,10);

  var pLength;
  var sLength;
  var position = strValue.indexOf(".");
  if(position>-1)
  {
    pLength = position;
    sLength = strValue.length - position - 1;
  }
  else
  {
    pLength = strValue.length;
    sLength = 0;
  }

  if(pLength>(p-s) || sLength>s)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����,����λ�Ϊ" + (p-s) + ",С��λ�Ϊ" + s);
    field.focus();
    field.select();
    return false;
  }

  var value = parseFloat(strValue);
  if(MaxValue!=null && MinValue!=null && trim(MaxValue)!="" && trim(MinValue)!="")
  {
    MinValue = parseFloat(MinValue);
    MaxValue = parseFloat(MaxValue);
    if(isNaN(value) || value>MaxValue || value<MinValue)
    {
      errorMessage("������Ϸ���" + desc +"\n����Ϊ����,��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
      field.focus();
      field.select();
      return false;
    }
  }

  return true;
}

//�������򰴼�ʱ������У��
function pressDecimal2(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="." || value=="-")
    return true;
  else
    return false;
}
//add end by liuyang 2003/10/14

////������š��ձ���뵽����
//var itemKindNoArray = new Array();
//
////����������š��ձ���뵽����
//function setItemKindNo(itemKindNo)
//{
//  itemKindNoArray = itemKindNo;
//}
//
////ȡ������š��ձ���룬���Ϊ�ַ����ĺ���
//function getItemKindNo()
//{
//  var strCodes="";
//
//	if(itemKindNoArray.length==0) return null;
//
//  for(var i=0;i<itemKindNoArray.length;i++)
//  {
//    strCodes=strCodes+itemKindNoArray[i].ItemKindNo+FIELD_SEPARATOR+itemKindNoArray[i].KindCode+GROUP_SEPARATOR;
//  }
//
//  strCodes=strCodes.substring(0,strCodes.length-GROUP_SEPARATOR.length);
//  return strCodes;
//
//}



//�������
//function processLendor(strClaimNo)
//{
//  var strURL = "/prpall/temp/common/lp/UILendorInput.jsp?ClaimNo="+strClaimNo;
//  var newWindow = window.open(strURL,"Lendor",'width=640,height=270,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
//  newWindow.focus();
//}
//�鿴�������
//function showLendor(strClaimNo)
//{
//  var strURL = "/prpall/temp/common/lp/UILendorShow.jsp?ClaimNo="+strClaimNo;
//  var newWindow = window.open(strURL,"Relate",'width=640,height=270,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
//  newWindow.focus();
//}



//
//
//����
//
//
//
////�Ը�ʽ�ַ������н���,����һ����������
////��ʽ�ַ��� FieldName:FieldValue|
////��������   array[FieldName]=FieldValue
//function splitField(record)
//{
//  var arrayField=record.split(FIELDDELIMITER);
//  var arrayReturn=new Array();
//  var i;
//  for(i=0;i<arrayField.length-1;i++)
//  {
//    var arrayNameValuePair=arrayField[i].split(NAMEVALUEDELIMITER);
//   //�ָ��һ����������ֵ
//    arrayReturn[arrayNameValuePair[0]]=arrayNameValuePair[1];
//  }
//  return arrayReturn;
//}
//
///* ��ָ���ı���ǰ��0��ֱ������ָ��λ�� */
//function addZero(strValue,intLen)
//{
//  var i,len;
//  var strRet;
//  strRet=strValue.toString();
//  len=strRet.length;
//  if (len<intLen)
//  {
//    while (strRet.length!=intLen)
//    {
//      strRet="0"+strRet;
//    }
//    return strRet;
//  }
//  else
//  {
//    return strRet;
//  }
//}
//
//
////����ֵ��������Ϊ����ֵ��isMulti��ʾ�����Ƿ�Ϊ���������
//function setEmpty(FieldName,FieldValue,isMulti)
//{
//    var i = 0;
//    if (!isMulti)
//    {
//      if (fm.all(FieldName).value == "")
//        fm.all(FieldName).value = FieldValue;
//    }
//    else
//    {
//
//      for(i = 0; i< fm.all(FieldName).length; i++)
//      {
//        theField = fm.all(FieldName)[i];
//        if (trim(theField.value) == "" || isNaN(eval(theField.value)) || eval(theField.value) == 0)
//          theField.value = FieldValue;
//      }
//    }
//}
//
//�ָ���벢����select����
//���ĸ�ʽ: ֵFIELD_SEPARATOR�ı�GROUP_SEPARATORֵFIELD_SEPARATOR�ı�...
function setObjOption(selectObj,strValue)
{
  //�鲻�����뷵��
  if(strValue==null || trim(strValue)=="")
  {
    return;
  }
  var arrayField=strValue.split(GROUP_SEPARATOR);
  var i=0;
  selectObj.options.length = 0;
  while(i<arrayField.length)
  {
    var option=document.createElement("option");
    var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
    var strFieldName=arrayTemp[0];
    var strFieldValue=unescape(arrayTemp[1]);
    option.value=strFieldName;
    option.text=strFieldValue;
    selectObj.add(option);
    i++;
  }
}
//public
//���̲��ֿ���,select-one���и����¼���ȡ�� --OK��
function undoSetReadonlyOfElement(iElement)
{
  if(iElement.type=="select-one")
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    var optionTags = iElement.optionTags;
    var currentValue = iElement.value;

    for(var i=iElement.options.length-1;i>=0;i--)
    {
      iElement.remove(i);
    }

    for(var i=optionTags.length-1;i>=0;i--)
    {
      var tag = optionTags[i];
      var op = document.createElement("OPTION");
      op.value = tag.value;
      op.text =  tag.text;
      iElement.add(op);
    }
    iElement.value = currentValue;

  }
  else if ((iElement.type=="hidden") ||
            (iElement.type=="password") ||
            (iElement.type=="text") ||
            (iElement.type=="textarea"))
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    iElement.onblur = iElement.oldOnblur;
    iElement.ondblclick = iElement.oldOndblclick;
    iElement.onfocus = iElement.oldOnfocus;

    iElement.readOnly = false;
    iElement.className = iElement.oldClassName;
  }
  else if(iElement.type=="button")
  {
    if(iElement.setReadonlyFlag!=true)
    {
      return;
    }
    else
    {
      iElement.setReadonlyFlag = false;
    }

    if(iElement.name.indexOf("Delete")>-1 || iElement.name.indexOf("Insert")>-1)
    {
      iElement.disabled = false;
    }
  }
  else if(iElement.type=="checkbox")
  {
    setCheckBoxReadonly(iElement,false);
  }
  else if(iElement.type=="radio")
  {
    setRadioReadonly(iElement,false);
  }
}


/**
 @Author      ����ŷ
 @description �õ���n����
 @param       ��
 @return      ������n���������
 */  
function getBeforeDateFullDate(strDate,intCount)
{
  strDate = replace(strDate,"-","/");
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }
  var nextDateInMS = tempDate.getTime() - (intCount * 24 * 60 * 60 * 1000 );

  var strReturn = convertFullDateToString(new Date(nextDateInMS));
  return strReturn;
} 

/**
 @Author      ����ŷ
 @description �õ���n����
 @param       ��
 @return      ������n���µ�����
 */
function getBeforeMonthFullDate(strDate,intCount)
{
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }

  tempDate.setMonth(tempDate.getMonth() - intCount );
  var strReturn = convertFullDateToString(tempDate);
  return strReturn;
}
/**
 @Author      ����ŷ
 @description �õ���n����
 @param       ��
 @return      ������n���������
 */
function getBeforeYearFullDate(strDate,intCount)
{
  strDate = replace(strDate,"-","/");
  var tempDate = new Date(strDate);
  if(intCount == null)
  {
    intCount =1;
  }
  tempDate.setFullYear(tempDate.getFullYear() - intCount );
  var strReturn = convertFullDateToString(tempDate);
  return strReturn;
}

/**
* @���� Liujun
* @ʱ�� 2008-10-11
* @���� ��һ��ID�ڵ�inputԪ�ؼ��е���һ��ID�ڣ�������ԭʼֵ
*/
function cutElementsByID(sourceID,targetID,isShowTarget){
  var source = document.getElementById(sourceID);
  var target = document.getElementById(targetID);
  
  //����ԭʼֵ                 
  var inputs = source.getElementsByTagName("input");
  for(i=0;i<inputs.length;i++){
    if(inputs[i].type!="text"){
      continue;
    }
    inputs[i].setAttribute(sourceID,inputs[i].value,0);
    if(inputs[i].getAttribute(targetID)!=null){
      inputs[i].value = inputs[i].getAttribute(targetID);
    }else{
      inputs[i].value = "";
    }
  }

  //alert(source.id);
  //alert("source.childNodes=="+source.childNodes.length);
  
  for(j=0;j<source.childNodes.length;j++){
    target.appendChild(source.childNodes[j].cloneNode(true));
  }
  
  //alert(target.id);
  //alert("target.childNodes=="+target.childNodes.length);
  
  for(k=(source.childNodes.length-1);k>-1;k--){
    //alert("del:"+source.childNodes[k].nodeName);
    source.childNodes[k].removeNode(true);
  }
   
  //alert("cov---------");
  
  //for(m=0;m<source.childNodes.length;m++){
      //alert(source.childNodes[m].nodeName);
      //alert("source.childNodes[m].id=="+source.childNodes[m].id);
  //}
  
  //�Ƿ���ʾĿ��ҳ��
  if(isShowTarget){
    target.style.display = "";
    for(l=0;l<target.childNodes.length;l++){
      target.childNodes[l].style.display= "";
    }
  }
  
}

/**
* @���� Liujun
* @ʱ�� 2008-10-26
* @���� ��ø������ڼ����ż����
*/
function getParityDays(startDate,endDate){
   var results;
   
   startDate = replace(startDate,"-","/");
   endDate   = replace(endDate,"-","/");
     
   startDate = new Date(startDate);
   endDate = new Date(endDate);
   
   var oddCnt = 0;//��������
   var evenCnt= 0;//ż������
   
   while(Date.parse(startDate)<=Date.parse(endDate)){
   	   if(startDate.getDate()%2==0){
   	   	   evenCnt += 1;
   	   }else{
   	   	   oddCnt +=1;
   	   }
   	   startDate.setDate(startDate.getDate()+1);
   }   
   
   results = [oddCnt,evenCnt];//����
  
   return results;
}

/**
* @���� Liujun
* @ʱ�� 2008-10-31
* @���� ����������Ƿ��и�����ֵ
*/
function hasArrValue(arr,key){
	for(i=0;i<arr.length;i++){
		if(arr[i]==key){
			 return true;
			 break;
		} 
	}
  return false;
}

/**
* @���� Liujun
* @ʱ�� 2009-11-18
* @���� ��Select�ؼ���ֵ
*/
function setValueToSelect(filed,inputValue){
	for(i=0;i<filed.options.length;i++){
		if(filed.options[i].value==inputValue){
			 filed.options[i].selected = true;
             break;
		} 
	}
}	

/**
* @���� LiWentao
* @ʱ�� 2010-09-01
* @���� ��ȡ����֤��Ψһ��ʾ
*/
function getCardKey(){
	var info = "";  //��ȡ�����̱���
	try
  {
		var strTemp = bjcactrl.GetUserList();  //֤��ͨ������������5��������
		//alert(strTemp);
		var i=strTemp.indexOf("&&&");
		if(i>=0)
		{
			var	strOption = strTemp.substring(0,i);
			var agentName = strOption.substring(0, strOption.indexOf("||"));//��ȡ����������
			var strContainerName = strOption.substring(strOption.indexOf("||") + 2, strOption.length);  //��ȡ֤���������
			var lib = bjcactrl.GetUserInfo(strContainerName, 15);//��ȡkey������
			if(lib==null||lib=="")
	   	{
	   		alert("û�в���key");
	   		return;
	   	}
			var varCert = bjcactrl.ExportUserCert(strContainerName);//��ȡǩ��֤��
			info = bjcactrl.GetCertInfoByOid(varCert,"2.16.840.1.113732.2");//��ȡ�����̱���
	   	info = info.substring(2);
	   	var enableTime = bjcactrl.GetCertInfo(varCert,12);//��ȡ֤����Ч����
	   	var caid = bjcactrl.GetBjcaKeyParam(lib,3);//��ȡCAΨһ��ʶ
		}
  }
  catch(e)
  {
      errorMessage("����֤���ȡ�쳣��������û�а�װ�ؼ�������ϵIT��Ա�����"+e.message);
  }
	return info;
}	
/**
* @���� LiWentao
* @ʱ�� 2010-09-01
* @���� ��ȡ����ip
*/
function getLocalIPAddress()
{
    var obj = null;
    var vIP = "";
    try
    {
        obj = new ActiveXObject("rcbdyctl.Setting");
        vIP = obj.GetIPAddress;
        obj = null;
    }
    catch(e)
    {
        errorMessage("����IP��ȡ�쳣��������û�а�װ�ؼ�������ϵIT��Ա�����"+e.message);
    }
    
    return vIP;
}


function setDisabled(){
   fm.buttonSubmit.disabled="true";
   fm.buttonReset.disabled="true";
}


//function document.onkeydown() 
// { 
//	if (event.keyCode==122)   //����F11ȫ��
//    { 
//         event.keyCode = 0; 
//         event.cancelBubble = true; 
//         return false; 
//	}
//    if ((window.event.altKey)&&
//      ((window.event.keyCode==37)||   //���� Alt+ ����� ��
//       (window.event.keyCode==39))){  //���� Alt+ ����� ��
//       alert("��׼��ʹ��ALT+�����ǰ���������ҳ��");
//       event.returnvalue=false;
//     }	
//    if ((event.ctrlKey)&&(event.keyCode==78))   //���� Ctrl+n
//         event.returnvalue=false;
//    if ((event.shiftKey)&&(event.keyCode==121)) //���� shift+F10
//         event.returnvalue=false;     
//    if (window.event.srcElement.tagName == "A" && window.event.shiftKey) 
//         window.event.returnvalue = false;  //���� shift ���������¿�һ��ҳ
//    if ((window.event.altKey)&&(window.event.keyCode==115)){ //����Alt+F4
//        window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
//         return false;
//       }
//
//  if ((event.keyCode == 8) && 
//      (event.srcElement.type != "text" && 
//      event.srcElement.type != "textarea" && 
//      event.srcElement.type != "password") ||           //�����˸�ɾ����   
//      (event.ctrlKey && event.keyCode==82)){            //Ctrl + R
//         event.keyCode=0;
//         event.returnvalue=false;
//     }
//     
//     
//
// 
////if (window.Event) 
//  // document.captureEvents(Event.MOUSEUP); 
// 
////document.oncontextmenu = nocontextmenu;  // for IE5+
////document.onmousedown = norightclick;  // for all others     
//      
//}       
//       
//
//
//
//function nocontextmenu() 
//{ 
// alert("**********************1");
//   event.cancelBubble = true 
//   event.returnValue = false; 
//
//   return false; 
//} 
//
//function document.onmousedown(e) 
//{ 
//  if (window.Event) 
//  { 
//    if (e.which == 2 || e.which == 3) {
//
//    // return false; 
//    }
//   } 
//   else 
//   if (event.button == 2 || event.button == 3) 
//   { 
////     event.cancelBubble = true 
////    event.returnValue = false; 
////alert("*******************"+e.which);
//  //   return false; 
//    } 
//
//} 
//
////document.oncontextmenu = nocontextmenu; // for IE5+ 
////document.onmousedown = norightclick; // for all others        
//       
// 
//    
//function window.onhelp(){return false} //����F1����    