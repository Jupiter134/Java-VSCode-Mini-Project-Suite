//QuickSort
import java.util.*;

class Student
{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) 
    {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() 
    {
        return id;
    }
    public String getFname() 
    {
        return fname;
    }
    public double getCgpa() 
    {
        return cgpa;
    }
}

public class QuickSort 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        Student[] students = new Student[testCases];
        for (int i = 0; i < testCases; i++) 
        {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            students[i] = new Student(id, fname, cgpa);
        }
        recQuickSort(students, 0, testCases-1);

        for(Student st: students)
        {
            System.out.println(st.getFname());
        }
    }

    
    public static void recQuickSort(Student[] arr, int left, int right) 
    {

        //if left pointer >= right then stop
        if (left >= right) return;

        //choose pivot (last element)
        Student pivot = arr[right];

        int i = left - 1;

        for (int j = left; j < right; j++) 
        {
            //if element should come before the pivot
            boolean beforePivot = false;

            // higher cgpa first
            if (arr[j].getCgpa() > pivot.getCgpa()) 
            {
                beforePivot = true;
            } 
            //if cgpa is the same, sort by name
            else if (arr[j].getCgpa() == pivot.getCgpa()) 
            {
                //name alphabetical
                int nameCompare = arr[j].getFname().compareTo(pivot.getFname());

                //if names are different
                if (nameCompare < 0) 
                {
                    beforePivot = true;
                } 
                //if names are also the same
                else if (nameCompare == 0) 
                {
                    //lower ID first
                    if (arr[j].getId() < pivot.getId()) 
                    {
                        beforePivot = true;
                    }
                }
            }

            //swap if needed
            if (beforePivot) 
            {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //put pivot in right place
        Student temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        int pivotIndex = i + 1;

        // recursion
        recQuickSort(arr, left, pivotIndex - 1);
        recQuickSort(arr, pivotIndex + 1, right);
    }
}
 
//test:
// input list number, ie. 5
/* input student info
        33 Rumpa 3.68
        85 Ashis 3.85
        56 Samiha 3.75
        19 Samara 3.75
        22 Fahim 3.76

    correct output should be:
        Ashis
        Fahim
        Samara
        Samiha
        Rumpa
*/
