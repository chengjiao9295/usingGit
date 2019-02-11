import java.math.BigDecimal;
import java.util.*;

public class VOExt implements Map<String, Object> {
    protected static Map<String, Class<?>> typeMap = new HashMap<String,Class<?>>();

    static {
        typeMap.put("bankName", String.class);
        typeMap.put("contactor", String.class);
        typeMap.put("telephone", String.class);
        typeMap.put("address", String.class);
        typeMap.put("faxNum", String.class);
        typeMap.put("zipCode", String.class);
        typeMap.put("bankMaxLimit", BigDecimal.class);
        typeMap.put("startDate", Date.class);
        typeMap.put("endDate", Date.class);
        typeMap.put("categoryName", String.class);
        typeMap.put("categoryMaxLimit", BigDecimal.class);
        typeMap.put("trdType", Integer.class);
        typeMap.put("creditRate", BigDecimal.class);
        
    }

    protected Map<String, Object> dataMap = new HashMap<String,Object>();

        @Override
        public int size() {
        return dataMap.size();
    }

        @Override
        public boolean isEmpty() {
        return dataMap.isEmpty();
    }

        @Override
        public boolean containsKey(Object key) {
        return dataMap.containsKey(key);
    }

        @Override
        public boolean containsValue(Object key) {
        return dataMap.containsValue(key);
    }

        @Override
        public Object get(Object key) {
        return dataMap.get(key);
    }

        @Override
        public Object remove(Object key) {
        return dataMap.remove(key);
    }

        @Override
        public void putAll(Map<? extends String, ?> m) {
        dataMap.putAll(m);
    }

        @Override
        public void clear() {
        dataMap.clear();
    }

        @Override
        public Set<String> keySet() {
        return dataMap.keySet();
    }

        @Override
        public Collection<Object> values() {
        return dataMap.values();
    }

        @Override
        public Set<Map.Entry<String, Object>> entrySet() {
        return dataMap.entrySet();
    }

  
    public VOExt setBankName(String bankName) {
        dataMap.put("bankName",bankName);
        return this;
    }
    
    public String getBankName() {
        Object val = dataMap.get("bankName");
        if (null == val) {
            return null;
        }
        return (String)val;
    }
    public VOExt setContactor(String contactor) {
        dataMap.put("contactor",contactor);
        return this;
    }

    public String getContactor() {
        Object val = dataMap.get("contactor");
        if (null == val) {
            return null;
        }
        return (String)val;
    }
    /**
     * 电话 */
    public VOExt setTelephone(String telephone) {
        dataMap.put("telephone",telephone);
        return this;
    }

    /**
     * 电话 */
    public String getTelephone() {
        Object val = dataMap.get("telephone");
        if (null == val) {
            return null;
        }
        return (String)val;
    }

    /**
     * 地址 */
    public VOExt setAddress(String address) {
        dataMap.put("address",address);
        return this;
    }

    /**
     * 地址 */
    public String getAddress() {
        Object val = dataMap.get("address");
        if (null == val) {
            return null;
        }
        return (String)val;
    }

    /**
     * 传真号码 */
    public VOExt setFaxNum(String faxNum) {
        dataMap.put("faxNum",faxNum);
        return this;
    }

    /**
     * 传真号码 */
    public String getFaxNum() {
        Object val = dataMap.get("faxNum");
        if (null == val) {
            return null;
        }
        return (String)val;
    }

    /**
     * 邮编 */
    public VOExt setZipCode(String zipCode) {
        dataMap.put("zipCode",zipCode);
        return this;
    }

    /**
     * 邮编 */
    public String getZipCode() {
        Object val = dataMap.get("zipCode");
        if (null == val) {
            return null;
        }
        return (String)val;
    }
    public VOExt setBankMaxLimit(BigDecimal bankMaxLimit) {
        dataMap.put("bankMaxLimit", bankMaxLimit);
        return this;
    }

    public BigDecimal getBankMaxLimit() {
        return (BigDecimal) dataMap.get("bankMaxLimit");
    }
    public VOExt setStartDate(Date startDate) {
        dataMap.put("startDate", startDate);
        return this;
    }
    public Date getStartDate() {
        return (Date) dataMap.get("startDate");
    }
    public VOExt setEndDate(Date endDate) {
        dataMap.put("endDate", endDate);
        return this;
    }

    public Date getEndDate() {
        return (Date) dataMap.get("endDate");
    }

    public VOExt setCategoryName(String categoryName) {
        dataMap.put("categoryName", categoryName);
        return this;
    }

    public String getCategoryName() {
        return (String) dataMap.get("categoryName");
    }

    public VOExt setCategoryMaxLimit(BigDecimal categoryMaxLimit) {
        dataMap.put("categoryMaxLimit", categoryMaxLimit);
        return this;
    }

    public BigDecimal getCategoryMaxLimit() {
        return (BigDecimal) dataMap.get("categoryMaxLimit");
    }

    public VOExt setTrdType(Integer trdType) {
        dataMap.put("trdType", trdType);
        return this;
    }

    public Integer getTrdType() {
        return (Integer) dataMap.get("trdType");
    }

    public VOExt setCreditRate(BigDecimal creditRate) {
        dataMap.put("creditRate", creditRate);
        return this;
    }

    public BigDecimal getCreditRate() {
        return (BigDecimal) dataMap.get("creditRate");
    }

    @Override
    public Object put(String key, Object value) {
        if (null == value) { return dataMap.remove(key); } Class<?> clazz = typeMap.get(key);Object _value = null;if (null == clazz || clazz.isInstance(value)) {_value = value;} else if (String.class.isInstance(value)) { if (Integer.class.equals(clazz)) { _value = Integer.valueOf((String) value);} else if (BigDecimal.class.equals(clazz)) { _value = new BigDecimal((String) value); } else if (Boolean.class.equals(clazz)) { _value = new Boolean((String) value); } else if (Date.class.equals(clazz)) { _value = new Date(Long.parseLong((String) value)); } else if (Long.class.equals(clazz)) { _value = Long.parseLong((String) value); } else { throw new RuntimeException("Invalid data format : " + key); }} else {throw new RuntimeException("Invalid data format : " + key);} return dataMap.put(key, _value);}


//    private String bankName;
//    private String contactor;
//    private String telephone;
//    private String address;
//    private String faxNum;
//    private String zipCode;
//    private BigDecimal bankMaxLimit;
//    private Date startDate;
//    private Date endDate;
//    private String categoryName;
//    private BigDecimal categoryMaxLimit;
//    private int trdType;
//    private BigDecimal creditRate;

//
//    public String getBankName() {
//        return bankName;
//    }
//
//    public void setBankName(String bankName) {
//        this.bankName = bankName;
//    }
//
//    public String getContactor() {
//        return contactor;
//    }
//
//    public void setContactor(String contactor) {
//        this.contactor = contactor;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getFaxNum() {
//        return faxNum;
//    }
//
//    public void setFaxNum(String faxNum) {
//        this.faxNum = faxNum;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public BigDecimal getBankMaxLimit() {
//        return bankMaxLimit;
//    }
//
//    public void setBankMaxLimit(BigDecimal bankMaxLimit) {
//        this.bankMaxLimit = bankMaxLimit;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public BigDecimal getCategoryMaxLimit() {
//        return categoryMaxLimit;
//    }
//
//    public void setCategoryMaxLimit(BigDecimal categoryMaxLimit) {
//        this.categoryMaxLimit = categoryMaxLimit;
//    }
//
//    public int getTrdType() {
//        return trdType;
//    }
//
//    public void setTrdType(int trdType) {
//        this.trdType = trdType;
//    }
//
//    public BigDecimal getCreditRate() {
//        return creditRate;
//    }
//
//    public void setCreditRate(BigDecimal creditRate) {
//        this.creditRate = creditRate;
//    }
   }

