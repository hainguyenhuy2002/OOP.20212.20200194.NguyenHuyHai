import javax.swing.JOptionPane;
public class month_day {
    public static void main(String[] args){
        int year = 0; 
		int isMonth = 0;
        int isYear = 0;
		String month = " ";
        
        while (isMonth < 1){
            String strmonth = JOptionPane.showInputDialog(null,"Input the month ",
            "Input the month:",JOptionPane.INFORMATION_MESSAGE);
            if (strmonth.equals("January") || strmonth == ("Jan.") ||strmonth.equals("Jan") || strmonth.equals("1")){
				isMonth = 1;
                month = "January";
                
			}
			else if (strmonth.equals("February") || strmonth.equals("Feb.") ||strmonth.equals("Feb") || strmonth.equals("2")){
				isMonth = 1;
                month = "February";
			}
			else if (strmonth.equals("March") || strmonth.equals("Mar.") ||strmonth.equals("Mar") || strmonth.equals("3")){
				isMonth = 1;
                month = "March";
			}
			else if (strmonth.equals("April") || strmonth.equals("Apr.") ||strmonth.equals("Apr") || strmonth.equals("4")){
				isMonth = 1;
                month = "April";
			}
			else if (strmonth.equals("May") ||  strmonth.equals("5")){
				isMonth = 1;
                month = "May";
			}
			else if (strmonth.equals("June") || strmonth.equals("Jun") || strmonth.equals("6")){
				isMonth = 1;
                month = "June";
			}
			else if (strmonth.equals("July") || strmonth.equals("Jul") || strmonth.equals("7")){
				isMonth = 1;
                month = "July";
			}
			else if (strmonth.equals("August") || strmonth.equals("Aug.") ||strmonth.equals("Aug") || strmonth.equals("8")){
				isMonth = 1;
                month = "August";
			}
			else if (strmonth.equals("September") || strmonth.equals("Sept.") ||strmonth.equals("Sep") || strmonth.equals("9")){
				isMonth = 1;
                month = "September";
			}
			else if (strmonth.equals("October") || strmonth.equals("Oct.") ||strmonth.equals("Oct") || strmonth.equals("10")){
				isMonth = 1;
                month = "October";
			}
			else if (strmonth.equals("November") || strmonth.equals("Nov.") ||strmonth.equals("Nov") || strmonth.equals("11")){
				isMonth = 1;
                month = "November";
			}
			else if (strmonth.equals("December") || strmonth.equals("Dec.") ||strmonth.equals("Dec") || strmonth.equals("12")){
				isMonth = 1;
                month = "December";
			}
            
        }
        
        while (isYear < 1){
            year = Integer.parseInt(JOptionPane.showInputDialog(null,"Input the year (Year is an integer number) ",
                "Input the year:",JOptionPane.INFORMATION_MESSAGE));
            isYear = 1;
        }

        
        if (month == "January" || month == "March" || month == "May" || month == "July" || month == "August" || month == "October" || month == "December"){
			JOptionPane.showMessageDialog(null,month +" has 31 days in the year = " + year ,"result",JOptionPane.INFORMATION_MESSAGE);
		}
        if (month == "April" || month == "June" || month == "September" || month == "November"){
			JOptionPane.showMessageDialog(null,month +" has 30 days in the year = " + year ,"result",JOptionPane.INFORMATION_MESSAGE);
		}
        if (month == "February")
        {
            if ((year%4!=0) ||((year % 100 == 0) && (year %400 != 0))) {
                JOptionPane.showMessageDialog(null,month +" has 28 days in the year = " + year ,"result",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,month +" has 29 days in the year = " + year ,"result",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
}

