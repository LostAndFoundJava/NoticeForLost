package com.nfl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NflPostRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NflPostRelationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdIsNull() {
            addCriterion("commented_msg_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdIsNotNull() {
            addCriterion("commented_msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdEqualTo(Integer value) {
            addCriterion("commented_msg_id =", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdNotEqualTo(Integer value) {
            addCriterion("commented_msg_id <>", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdGreaterThan(Integer value) {
            addCriterion("commented_msg_id >", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commented_msg_id >=", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdLessThan(Integer value) {
            addCriterion("commented_msg_id <", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("commented_msg_id <=", value, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdIn(List<Integer> values) {
            addCriterion("commented_msg_id in", values, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdNotIn(List<Integer> values) {
            addCriterion("commented_msg_id not in", values, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("commented_msg_id between", value1, value2, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commented_msg_id not between", value1, value2, "commentedMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdIsNull() {
            addCriterion("commented_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdIsNotNull() {
            addCriterion("commented_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdEqualTo(Integer value) {
            addCriterion("commented_user_id =", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdNotEqualTo(Integer value) {
            addCriterion("commented_user_id <>", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdGreaterThan(Integer value) {
            addCriterion("commented_user_id >", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commented_user_id >=", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdLessThan(Integer value) {
            addCriterion("commented_user_id <", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("commented_user_id <=", value, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdIn(List<Integer> values) {
            addCriterion("commented_user_id in", values, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdNotIn(List<Integer> values) {
            addCriterion("commented_user_id not in", values, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("commented_user_id between", value1, value2, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commented_user_id not between", value1, value2, "commentedUserId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdIsNull() {
            addCriterion("comment_msg_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdIsNotNull() {
            addCriterion("comment_msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdEqualTo(Integer value) {
            addCriterion("comment_msg_id =", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdNotEqualTo(Integer value) {
            addCriterion("comment_msg_id <>", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdGreaterThan(Integer value) {
            addCriterion("comment_msg_id >", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_msg_id >=", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdLessThan(Integer value) {
            addCriterion("comment_msg_id <", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_msg_id <=", value, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdIn(List<Integer> values) {
            addCriterion("comment_msg_id in", values, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdNotIn(List<Integer> values) {
            addCriterion("comment_msg_id not in", values, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_msg_id between", value1, value2, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_msg_id not between", value1, value2, "commentMsgId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIsNull() {
            addCriterion("comment_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIsNotNull() {
            addCriterion("comment_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdEqualTo(Integer value) {
            addCriterion("comment_user_id =", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotEqualTo(Integer value) {
            addCriterion("comment_user_id <>", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdGreaterThan(Integer value) {
            addCriterion("comment_user_id >", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_user_id >=", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdLessThan(Integer value) {
            addCriterion("comment_user_id <", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_user_id <=", value, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdIn(List<Integer> values) {
            addCriterion("comment_user_id in", values, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotIn(List<Integer> values) {
            addCriterion("comment_user_id not in", values, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_user_id between", value1, value2, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_user_id not between", value1, value2, "commentUserId");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIsNull() {
            addCriterion("comment_type is null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIsNotNull() {
            addCriterion("comment_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTypeEqualTo(Integer value) {
            addCriterion("comment_type =", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotEqualTo(Integer value) {
            addCriterion("comment_type <>", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThan(Integer value) {
            addCriterion("comment_type >", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_type >=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThan(Integer value) {
            addCriterion("comment_type <", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("comment_type <=", value, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeIn(List<Integer> values) {
            addCriterion("comment_type in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotIn(List<Integer> values) {
            addCriterion("comment_type not in", values, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeBetween(Integer value1, Integer value2) {
            addCriterion("comment_type between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_type not between", value1, value2, "commentType");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andPageIndexIsNull() {
            addCriterion("page_index is null");
            return (Criteria) this;
        }

        public Criteria andPageIndexIsNotNull() {
            addCriterion("page_index is not null");
            return (Criteria) this;
        }

        public Criteria andPageIndexEqualTo(Integer value) {
            addCriterion("page_index =", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexNotEqualTo(Integer value) {
            addCriterion("page_index <>", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexGreaterThan(Integer value) {
            addCriterion("page_index >", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_index >=", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexLessThan(Integer value) {
            addCriterion("page_index <", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexLessThanOrEqualTo(Integer value) {
            addCriterion("page_index <=", value, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexIn(List<Integer> values) {
            addCriterion("page_index in", values, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexNotIn(List<Integer> values) {
            addCriterion("page_index not in", values, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexBetween(Integer value1, Integer value2) {
            addCriterion("page_index between", value1, value2, "pageIndex");
            return (Criteria) this;
        }

        public Criteria andPageIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("page_index not between", value1, value2, "pageIndex");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}