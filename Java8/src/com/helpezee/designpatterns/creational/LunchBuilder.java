package com.helpezee.designpatterns.creational;

public class LunchBuilder {

	private final String lunchType;
	private final String lunchName;
	private final String lunchCost;

	public LunchBuilder(Builder builder) {
		lunchType = builder.lunchType;
		lunchName = builder.lunchName;
		lunchCost = builder.lunchCost;

	}

	public static class Builder {

		private String lunchType;
		private String lunchName;
		private String lunchCost;

		public Builder() {
		}

		public LunchBuilder build() {
			return new LunchBuilder(this);
		}

		public Builder addLunchType(String lunchType) {
			this.lunchType = lunchType;
			return this;
		}

		public Builder addLunchName(String lunchName) {
			this.lunchName = lunchName;
			return this;
		}

		public Builder addLunchCost(String lunchCost) {
			this.lunchCost = lunchCost;
			return this;
		}

	}

	public String getLunchType() {
		return lunchType;
	}

	public String getLunchName() {
		return lunchName;
	}

	public String getLunchCost() {
		return lunchCost;
	}

}
