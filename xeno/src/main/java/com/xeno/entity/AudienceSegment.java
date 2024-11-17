package com.xeno.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AudienceSegment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private String spendvisitcondition;
	    private Integer spendingValue;          // Spending amount (e.g., 10000)
	    private String visitCondition;          // Visit condition (e.g., "greater", "less", "equal")
	    private Integer visitValue;             // Visit count value (e.g., 3)
	    private String lastVisitCondition;      // Last visit condition (e.g., "before", "within")
	    private Integer lastVisitMonths;        // Last visit in months (e.g., 3)
	    private String conditionLogic;          // AND/OR logic for combining conditions
	    private Integer audienceSize;

	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAudienceSize() {
			return audienceSize;
		}
		public void setAudienceSize(Integer audienceSize) {
			this.audienceSize = audienceSize;
		}
		public Integer getSpendingValue() {
			return spendingValue;
		}
		public void setSpendingValue(Integer spendingValue) {
			this.spendingValue = spendingValue;
		}
		public String getVisitCondition() {
			return visitCondition;
		}
		public void setVisitCondition(String visitCondition) {
			this.visitCondition = visitCondition;
		}
		public Integer getVisitValue() {
			return visitValue;
		}
		public void setVisitValue(Integer visitValue) {
			this.visitValue = visitValue;
		}
		public String getLastVisitCondition() {
			return lastVisitCondition;
		}
		public void setLastVisitCondition(String lastVisitCondition) {
			this.lastVisitCondition = lastVisitCondition;
		}
		public Integer getLastVisitMonths() {
			return lastVisitMonths;
		}
		public void setLastVisitMonths(Integer lastVisitMonths) {
			this.lastVisitMonths = lastVisitMonths;
		}
		public String getConditionLogic() {
			return conditionLogic;
		}
		public void setConditionLogic(String conditionLogic) {
			this.conditionLogic = conditionLogic;
		}
		public String getSpendvisitcondition() {
			return spendvisitcondition;
		}
		public void setSpendvisitcondition(String spendvisitcondition) {
			this.spendvisitcondition = spendvisitcondition;
		}
	    public AudienceSegment() {}

	    public AudienceSegment(String name, String spendvisitcondition, Integer spendingValue, String visitCondition,
	                           Integer visitValue, String lastVisitCondition, Integer lastVisitMonths, String conditionLogic) {
	        this.name = name;
	        this.spendvisitcondition = spendvisitcondition;
	        this.spendingValue = spendingValue;
	        this.visitCondition = visitCondition;
	        this.visitValue = visitValue;
	        this.lastVisitCondition = lastVisitCondition;
	        this.lastVisitMonths = lastVisitMonths;
	        this.conditionLogic = conditionLogic;
	    }
		public AudienceSegment save(AudienceSegment segment) {
			// TODO Auto-generated method stub
			return null;
		}
	   
	}

