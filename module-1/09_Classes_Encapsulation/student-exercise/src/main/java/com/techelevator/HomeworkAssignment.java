package com.techelevator;


public class HomeworkAssignment {
	
		
		private int earnedMarks;
		private int possibleMarks;
		private String submitterName;

		//derived
		private String letterGrade;
		
		
		
		//getters

		public int getEarnedMarks() {
			return this.earnedMarks;
			
		}
		public int getPossibleMarks() {
			return this.possibleMarks;
			
		}
		public String getSubmitterName() {
			return this.submitterName;
			
		}
		
		//private final static String[] PERCENT_TO_GRADE = {
				//"A", "B", "C", "D"};

		/*For 90% or greater, it returns "A"
		For 80-89%, it returns "B"
		For 70-79%, it returns "C"
		For 60-69%, it returns "D"
		Otherwise, it returns "F"*/
		
		
		
		public void setEarnedMarks(int earnedMarks) {
			this.earnedMarks =earnedMarks  ;
			
		}
		public void setPossibleMarks(int possibleMarks) {
			this.possibleMarks=possibleMarks;
			
		}
		public void setSubmitterName(String submitterName) {
			this.submitterName=submitterName;
			
		}

		//derived
		public String getLetterGrade() {
			double percentGrade = (earnedMarks / possibleMarks);
			if (percentGrade>=90) {
				letterGrade= "A";
			} else if (percentGrade>=80) {
				letterGrade= "B";
			}
			else if (percentGrade>=70) {
				letterGrade= "C";
			}
			else if (percentGrade>=60) {
				letterGrade= "D";
			}else {
				letterGrade= "F";
			}
			return letterGrade;
		}
		
		
		
		
		public HomeworkAssignment(int possibleMarks, String submitterName) {
			this.possibleMarks = possibleMarks;
			this.submitterName = submitterName;

		}
		


	}


