package com.sinosoft.one.test.rule.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="GE_PRO_FORCEFACTOR")
public class ProForceFactor
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String orderNo;
  private ProOrder proOrder;
  private String querySequenceNo;
  private Date queryDate;
  private Date queryPastDate;
  private BigDecimal ntgtfld32;
  private BigDecimal ntgtfld33;
  private BigDecimal ntgtfld34;
  private BigDecimal ntgtfld12;
  private BigDecimal ntgtfld13;
  private BigDecimal ntgtfld14;
  private BigDecimal ntgtfld15;
  private BigDecimal ntgtfld19;
  private BigDecimal ntgtfld10;
  private BigDecimal ntgtfld7;
  private BigDecimal ntgtfld8;
  private BigDecimal ntgtfld9;
  private BigDecimal ntgtfld11;
  private BigDecimal ntgtfld24;
  private BigDecimal ntgtfld25;
  private BigDecimal ntgtfld26;
  private BigDecimal ntgtfld6;
  private BigDecimal ntgtfld2;
  private BigDecimal ntgtfld3;

  @Id
  @GeneratedValue(generator="generator")
  @Column(name="ORDERNO")
  public String getOrderNo()
  {
    return this.orderNo;
  }

  public void setOrderNo(String orderNo)
  {
    this.orderNo = orderNo;
  }

  @OneToOne(fetch=FetchType.LAZY)
  @PrimaryKeyJoinColumn
  public ProOrder getProOrder()
  {
    return this.proOrder;
  }

  public void setProOrder(ProOrder proOrder)
  {
    this.proOrder = proOrder;
  }

  @Column(name="QUERYSEQUENCENO")
  public String getQuerySequenceNo()
  {
    return this.querySequenceNo;
  }

  public void setQuerySequenceNo(String querySequenceNo)
  {
    this.querySequenceNo = querySequenceNo;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="QUERYDATE")
  public Date getQueryDate()
  {
    return this.queryDate;
  }

  public void setQueryDate(Date queryDate)
  {
    this.queryDate = queryDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="QUERYPASTDATE")
  public Date getQueryPastDate()
  {
    return this.queryPastDate;
  }

  public void setQueryPastDate(Date queryPastDate)
  {
    this.queryPastDate = queryPastDate;
  }

  @Column(name="NTGTFLD32")
  public BigDecimal getNtgtfld32()
  {
    return this.ntgtfld32;
  }

  public void setNtgtfld32(BigDecimal ntgtfld32)
  {
    this.ntgtfld32 = ntgtfld32;
  }

  @Column(name="NTGTFLD33")
  public BigDecimal getNtgtfld33()
  {
    return this.ntgtfld33;
  }

  public void setNtgtfld33(BigDecimal ntgtfld33)
  {
    this.ntgtfld33 = ntgtfld33;
  }

  @Column(name="NTGTFLD34")
  public BigDecimal getNtgtfld34()
  {
    return this.ntgtfld34;
  }

  public void setNtgtfld34(BigDecimal ntgtfld34)
  {
    this.ntgtfld34 = ntgtfld34;
  }

  @Column(name="NTGTFLD12")
  public BigDecimal getNtgtfld12()
  {
    return this.ntgtfld12;
  }

  public void setNtgtfld12(BigDecimal ntgtfld12)
  {
    this.ntgtfld12 = ntgtfld12;
  }

  @Column(name="NTGTFLD13")
  public BigDecimal getNtgtfld13()
  {
    return this.ntgtfld13;
  }

  public void setNtgtfld13(BigDecimal ntgtfld13)
  {
    this.ntgtfld13 = ntgtfld13;
  }

  @Column(name="NTGTFLD14")
  public BigDecimal getNtgtfld14()
  {
    return this.ntgtfld14;
  }

  public void setNtgtfld14(BigDecimal ntgtfld14)
  {
    this.ntgtfld14 = ntgtfld14;
  }

  @Column(name="NTGTFLD15")
  public BigDecimal getNtgtfld15()
  {
    return this.ntgtfld15;
  }

  public void setNtgtfld15(BigDecimal ntgtfld15)
  {
    this.ntgtfld15 = ntgtfld15;
  }

  @Column(name="NTGTFLD19")
  public BigDecimal getNtgtfld19()
  {
    return this.ntgtfld19;
  }

  public void setNtgtfld19(BigDecimal ntgtfld19)
  {
    this.ntgtfld19 = ntgtfld19;
  }

  @Column(name="NTGTFLD10")
  public BigDecimal getNtgtfld10()
  {
    return this.ntgtfld10;
  }

  public void setNtgtfld10(BigDecimal ntgtfld10)
  {
    this.ntgtfld10 = ntgtfld10;
  }

  @Column(name="NTGTFLD7")
  public BigDecimal getNtgtfld7()
  {
    return this.ntgtfld7;
  }

  public void setNtgtfld7(BigDecimal ntgtfld7)
  {
    this.ntgtfld7 = ntgtfld7;
  }

  @Column(name="NTGTFLD8")
  public BigDecimal getNtgtfld8()
  {
    return this.ntgtfld8;
  }

  public void setNtgtfld8(BigDecimal ntgtfld8)
  {
    this.ntgtfld8 = ntgtfld8;
  }

  @Column(name="NTGTFLD9")
  public BigDecimal getNtgtfld9()
  {
    return this.ntgtfld9;
  }

  public void setNtgtfld9(BigDecimal ntgtfld9)
  {
    this.ntgtfld9 = ntgtfld9;
  }

  @Column(name="NTGTFLD11")
  public BigDecimal getNtgtfld11()
  {
    return this.ntgtfld11;
  }

  public void setNtgtfld11(BigDecimal ntgtfld11)
  {
    this.ntgtfld11 = ntgtfld11;
  }

  @Column(name="NTGTFLD24")
  public BigDecimal getNtgtfld24()
  {
    return this.ntgtfld24;
  }

  public void setNtgtfld24(BigDecimal ntgtfld24)
  {
    this.ntgtfld24 = ntgtfld24;
  }

  @Column(name="NTGTFLD25")
  public BigDecimal getNtgtfld25()
  {
    return this.ntgtfld25;
  }

  public void setNtgtfld25(BigDecimal ntgtfld25)
  {
    this.ntgtfld25 = ntgtfld25;
  }

  @Column(name="NTGTFLD26")
  public BigDecimal getNtgtfld26()
  {
    return this.ntgtfld26;
  }

  public void setNtgtfld26(BigDecimal ntgtfld26)
  {
    this.ntgtfld26 = ntgtfld26;
  }

  @Column(name="NTGTFLD6")
  public BigDecimal getNtgtfld6()
  {
    return this.ntgtfld6;
  }

  public void setNtgtfld6(BigDecimal ntgtfld6)
  {
    this.ntgtfld6 = ntgtfld6;
  }

  @Column(name="NTGTFLD2")
  public BigDecimal getNtgtfld2()
  {
    return this.ntgtfld2;
  }

  public void setNtgtfld2(BigDecimal ntgtfld2)
  {
    this.ntgtfld2 = ntgtfld2;
  }

  @Column(name="NTGTFLD3")
  public BigDecimal getNtgtfld3()
  {
    return this.ntgtfld3;
  }

  public void setNtgtfld3(BigDecimal ntgtfld3)
  {
    this.ntgtfld3 = ntgtfld3;
  }
}

/* Location:           C:\Users\carvin\Desktop\order-0.1.0-SNAPSHOT.jar
 * Qualified Name:     com.sinosoft.ebusiness.order.model.ProForceFactor
 * JD-Core Version:    0.6.0
 */