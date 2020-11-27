package Entity;

/**
 * Created by jacky on 30/11/2017.
 */
public class Date {
    int day;
    int month;
    int year;
    int second;
    int minute;
    int hour;

    public Date() {
    }

    public Date(String m_strDate) {
       Date date = StringToDate(m_strDate);
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
        this.second = date.second;
        this.minute = date.minute;
        this.hour = date.hour;
    }

    public Date(int day, int month, int year, int second, int minute, int hour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isBiguer(Date m_date) {
        boolean isBiguer = false;
        if (this.year > m_date.year) {
            isBiguer = true;
        } else if ((this.year == m_date.year) && (this.month > m_date.month)) {
            isBiguer = true;
        } else if ((this.year == m_date.year) && (this.month == m_date.month) && (this.day > m_date.day)) {
            isBiguer = true;
        } else if ((this.year == m_date.year) && (this.month == m_date.month) && (this.day == m_date.day) && (this.hour > m_date.hour)) {
            isBiguer = true;
        } else if ((this.year == m_date.year) && (this.month == m_date.month) && (this.day == m_date.day) && (this.hour == m_date.hour) && (this.minute > m_date.minute)) {
            isBiguer = true;
        } else if ((this.year == m_date.year) && (this.month == m_date.month) && (this.day == m_date.day) && (this.hour == m_date.hour) && (this.minute == m_date.minute) && (this.second > m_date.second)) {
            isBiguer = true;
        }
        return isBiguer;
    }

    public static Date StringToDate(String m_str_date) {
        Date dateToReturn = new Date();
        int nStrLength = m_str_date.length();
        char[] charDateArray = new char[nStrLength];
        charDateArray = m_str_date.toCharArray();
        String strTmp = "";

        // Day section;
        strTmp = String.valueOf(charDateArray[0]);
        strTmp += String.valueOf(charDateArray[1]);
        dateToReturn.day = Integer.parseInt(strTmp);

        // Month section;
        strTmp = String.valueOf(charDateArray[3]);
        strTmp += String.valueOf(charDateArray[4]);
        dateToReturn.month = Integer.parseInt(strTmp);

        // Year section;
        strTmp = String.valueOf(charDateArray[6]);
        strTmp += String.valueOf(charDateArray[7]);
        strTmp += String.valueOf(charDateArray[8]);
        strTmp += String.valueOf(charDateArray[9]);
        dateToReturn.year = Integer.parseInt(strTmp);


        // Hour section;
        strTmp = String.valueOf(charDateArray[11]);
        strTmp += String.valueOf(charDateArray[12]);
        dateToReturn.hour = Integer.parseInt(strTmp);

        // Minute section;
        strTmp = String.valueOf(charDateArray[14]);
        strTmp += String.valueOf(charDateArray[15]);
        dateToReturn.minute = Integer.parseInt(strTmp);

        // Second section;
        strTmp = String.valueOf(charDateArray[17]);
        strTmp += String.valueOf(charDateArray[18]);
        dateToReturn.second = Integer.parseInt(strTmp);

        return dateToReturn;
    }

    @Override
    public String toString() {
        return "\tDate: \t"+year+"-"+month+"-"+day+",\t In: \t"+hour+":"+minute+":"+second;
    }
}
