public class JuminNum {

    String num ;
    int day, month, year ;
    public JuminNum(String num) {
        this.num = num ;
    }
    public void Juminday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void juminGender() {
        if (num.charAt(7) % 2 == 0 ) {
            System.out.println("여");
        } else {
            System.out.println("남");
        }
    }

    public void juminNationality() {
        switch (num.charAt(7)-'0') {
            case 1: case 2: case 3: case 4: case 9: case 0:
                System.out.println("내국인");
                break;
            case 5: case 6: case 7: case 8:
                System.out.println("외국인");
                break;
        }
    }

    public void juminBirth () {
        System.out.println(num.substring(0,6));
    }

    public void juminKorAge() {
        String a = num.substring(0,2);
        int ageYear = Integer.parseInt(a) +1900;
        System.out.println(year- ageYear+1);
    }

    public void juminAge() {
        String a = num.substring(0,2);
        int ageYear = Integer.parseInt(a) +1900;
        System.out.println(year- ageYear);
    }


}
