package wiley.internship.com;


import java.util.*;

public class Comparing {
	public static void main(String[] args) {
		
		ArrayList li = new ArrayList<User>();
		li.add(new User(1000,"BOM","EMP1"));
		li.add(new User(1200,"DEL","EMP2"));
		li.add(new User(1000,"BLR","EMP3"));
			Collections.sort(li,new UserSortByName());

			for (Object u:li) {
				User user = (User)u;
				System.out.println(user.salary +" -- "+user.place+" -- "+user.id);
			}


	}
}

class User implements Comparable{
      int salary;
      String place;
	  String id;

    public User(int salary,String place,String id){
        this.salary = salary;
        this.place = place;
		this.id=id;
    }

	@Override
    public int compareTo(Object o) {
        User user = (User)o;

        if(this.salary > user.salary){
            return 1;
        }else if(this.salary < user.salary){
            return -1;
        }else{
            return 0;
        }
    }


}

class UserSortByName implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        User user1 = (User)o1;
        User user2 = (User)o2;
        int comparedTo = user1.compareTo(user2);

       if(user1.id.compareTo(user2.id)!=0) {
    	   return user1.id.compareTo(user2.id);
       }
        
        else if(comparedTo !=0){
            return comparedTo;
        }
        // second sorting
        String place1 = user1.place;
        String place2 = user2.place;
        return place1.compareTo(place2);
    }
}
