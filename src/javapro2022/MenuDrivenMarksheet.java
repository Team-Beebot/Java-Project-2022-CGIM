package javapro2022;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuDrivenMarksheet{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int chooseNumber;
        char cr;
        do {
            System.out.println("1. Add student information you want:");
            System.out.println("2. View all the information:");
            System.out.println("3. View information of student by Roll Number.");
            System.out.println("4. View all the rank of Students in descending order: ");
            System.out.println("5. Remove all the information about student or by Roll number:");
            System.out.println("6. Exit this Menu Driven Program:");
            System.out.println();
            System.out.print("Enter your choice: ");
            chooseNumber=sc.nextInt();

            // menudriven part start:

            switch(chooseNumber){
                case 1:
                    addDetailsOfStudents();  // for adding data
                    break;
                case 2:
                    viewAllInformation();  // view data for previous details added
                    break;
                case 3:
                    viewDetailsFromRollNumber();  // sorting or viewing data of student from their rollnumbers.
                    break;
                case 4:
                    viewInformationInDescendingOrder();   // ranking in decending order.
                    break;
                case 5:
                    deleteInformation();  // delete all files or by roll numbers.
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, you enter a invalid input:");
                    break;
            }
            System.out.println("Do you want to continue(y/n): ");
            cr=sc.next().charAt(0);
        }while(cr=='y' || cr=='Y');
    }

//==============================================================================================================================

    public static int total=0;

    public static ArrayList<String> fname;
    public static ArrayList<String> lname;
    public static ArrayList<String> dob;
    public static ArrayList<String> gender;
    public static ArrayList<Integer> standard;
    public static ArrayList<Integer> rollno;
    public static ArrayList<Float> java;
    public static ArrayList<Float> database;
    public static ArrayList<Float> probability;
    public static ArrayList<Float> account;
    public static ArrayList<Float> percentage ;

    //===================================================================================================================

    public static void addDetailsOfStudents() {

        int num;

        Scanner sc=new Scanner(System.in);
        fname= new ArrayList<>();
        lname= new ArrayList<>();
        dob= new ArrayList<>();
        gender= new ArrayList<>();
        standard= new ArrayList<>();
        rollno= new ArrayList<>();
        java=new ArrayList<>();
        database = new ArrayList<>();
        probability = new ArrayList<>();
        account = new ArrayList<>();
        percentage = new ArrayList<>();

        System.out.print("Enter the number of students you want to enter: ");
        num = sc.nextInt();
        if(num==0 || num<0 ||num>=5){
            System.out.println("Sorry, you enter a invalid number.");
        }
        else {
            for (int i = 0; i < num; i++) {
                System.out.println();
                System.out.println("Student: " +(i+1));
                System.out.print("Enter the standard: ");
                standard.add(sc.nextInt());
                System.out.print("Enter the first name: ");
                fname.add(sc.next());
                System.out.print("Enter the last name: ");
                lname.add(sc.next());
                System.out.print("Enter the roll no: ");
                rollno.add(sc.nextInt());
                System.out.print("Enter the date of birth: ");
                dob.add(sc.next());
                System.out.print("Enter the gender: ");
                gender.add(sc.next());
                System.out.print("Enter the marks in Java: ");
                java.add(sc.nextFloat());
                System.out.print("Enter the marks in Database: ");
                database.add(sc.nextFloat());
                System.out.print("Enter the marks in Probability: ");
                probability.add(sc.nextFloat());
                System.out.print("Enter the marks in Account: ");
                account.add(sc.nextFloat());
                percentage.add((java.get(i)+ database.get(i)+ probability.get(i)+ account.get(i))/4);
            }
            total=total+num;

        }


    }

    //=============================================================================================================

    public static void viewAllInformation(){
        if(total==0){
            System.out.println("No data has been entered.");
        }
        else{
            System.out.println();
            System.out.println("Student Details");
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i=0;i<total;i++){
                System.out.println();
                System.out.println("Student: " +(i+1));
                System.out.println("Name: " +fname.get(i)+" "+lname.get(i));
                System.out.println("Standard: "+standard.get(i));
                System.out.println("Roll no: " +rollno.get(i));
                System.out.println("Date of birth: " +dob.get(i));
                System.out.println("Gender: " +gender.get(i));
                System.out.println("Percentage: " +percentage.get(i)+"%");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

        }

    }

    //======================================================================================================

    public static void viewDetailsFromRollNumber(){  // view information of student you previously store.
        int roll;
        Scanner sc= new Scanner(System.in);
        if(total==0){
            System.out.println("No data has been entered.");
        }
        else{
            System.out.println();
            System.out.println("Enter the roll no of the student to search: ");
            roll = sc.nextInt();
            int s=0;

            for(int i=0;i<total;i++){
                if(roll==rollno.get(i)){
                    s=s+1;
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Name " +fname.get(i)+" "+lname.get(i));
                    System.out.println("Standard: "+standard.get(i));
                    System.out.println("Roll no: " +rollno.get(i));
                    System.out.println("Maths: "+java.get(i));
                    System.out.println("Science: "+database.get(i));
                    System.out.println("Social: "+probability.get(i));
                    System.out.println("English: "+account.get(i));
                    System.out.println("Percentage: " +percentage.get(i));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                }

            }
            if(s>0) {
                System.out.println("Invalid entry. ");
            }
        }

    }

    //==============================================================================================================
    public static void viewInformationInDescendingOrder(){
        //  percentage.sort(Comparator.reverseOrder());
        if(total==0){
            System.out.println("No data has been entered.");
        }
        else{
            System.out.println();
            int c= percentage.size();
            for (int i=0; i<c-1; i++)
            {
                int percentage_sorting = i;
                for (int j=i+1; j<c; j++)
                {
                    if (percentage.get(j) > percentage.get(percentage_sorting))
                    {
                        percentage_sorting = j;
                    }
                }
                float p = percentage.get(percentage_sorting);
                percentage.add(percentage_sorting, percentage.get(i)) ;
                percentage.add(i,p);

                String f = fname.get(percentage_sorting);
                fname.add(percentage_sorting,fname.get(i));
                fname.add(i,f);

                String l = lname.get(percentage_sorting);
                lname.add(percentage_sorting,lname.get(i));
                lname.add(i,l);
            }
            System.out.println("Result: ");

            for (int i=0;i<=c;i++){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Rank: " +(i+1));
                System.out.println();
                System.out.println("Percentage: "+percentage.get(i));
                System.out.println("Name: " +fname.get(i)+" "+lname.get(i));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

        }
    }



//================================================================================================================================



    public static void deleteInformation(){
        int r;
        Scanner sc= new Scanner(System.in);
        if(total==0){
            System.out.println("No data has been entered.");
        }
        else{
            int choice;
            System.out.println("Enter 1 to delete all record:");
            System.out.println("Enter 2 to delete the record of a student");
            choice= sc.nextInt();

            if(choice==1){
                total=0;
                System.out.println("All the records have been deleted.");

            }
            else if(choice==2){
                System.out.println("Enter the roll no of the student you miss delete the record of: ");
                r= sc.nextInt();

                for(int i=0;i<total;i++){
                    if(r==rollno.get(i)){
                        for(int j=i;j<total;j++){
                            standard.remove(j);
                            fname.remove(j);
                            lname.remove(j);
                            rollno.remove(j);
                            dob.remove(j);
                            gender.remove(j);
                            percentage.remove(j);
                        }
                        total=total-1;
                        System.out.println("Your Required Record is Deleted.");

                    }
                }

            }
            else {
                System.out.println("Sorry, The input is invalid!!");
            }

        }

    }






}
