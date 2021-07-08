package wiley.internship.com;

import java.util.*;

public class SortingFunc {

	public static void main(String[] args) {
		Set<Type> customSet = new TreeSet<>(new CaseThree());
		customSet.add(new Type(new LetUser(1, "Anitesh")));
		customSet.add(new Type(new Integer(3)));
		customSet.add(new Type("Nikhil"));
		customSet.add(new Type(new Integer(4)));
		customSet.add(new Type("Lekhya"));
		customSet.add(new Type(new LetUser(2, "Venkat")));


		customSet.forEach(System.out::println);

	}

}

class LetUser {
	int id;
	String name;

	public LetUser(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id+"  "+ name;
	}
	int getId() {
		return id;
	}
	String getName() {
		return name;
	}
	
	

}

class Type {
	private Object object;

	public Type(Object object) {
		this.object= object;
	}

	public Object getObject() {
		return object;
	}

	 @Override
	 public String toString(){
	 	return object+" ";
	 }

	
	
}



class CaseOne implements Comparator<Type>{

	@Override
	public int compare(Type argo, Type arg1) {
		
		if(argo.getObject() instanceof Integer){
			if(arg1.getObject() instanceof Integer) {
				
				int i = (int)arg1.getObject();
                int j = (int)argo.getObject();
                return j - i;
            }
            return -1;
			}
		else if(argo.getObject() instanceof LetUser) {

			if(arg1.getObject() instanceof Integer){
				return 1;
			}
			else if(arg1.getObject() instanceof String){
				return -1;
			}
			else if(arg1.getObject() instanceof LetUser){
				return   ((LetUser) argo.getObject()).getId()- ((LetUser)arg1.getObject()).getId() ;
			}	
		}
		
		else if(argo.getObject() instanceof String){
			if(arg1.getObject() instanceof String){
				return	((String) argo.getObject()).compareTo((String) arg1.getObject());
			}
			else if(arg1.getObject() instanceof Integer){
				return 1;
			}
			else if(arg1.getObject() instanceof LetUser) {
				return 1;
			}
			return -1;

		}
		
		return 0;
	}
	
}


class CaseTwo implements Comparator<Type>{

	@Override
	public int compare(Type argo, Type arg1) {
		
		if(argo.getObject() instanceof Integer){
			if(arg1.getObject() instanceof Integer) {
				
				int i = (int)arg1.getObject();
                int j = (int)argo.getObject();
                return j - i;
            }
            return 1;
			}
		else if(argo.getObject() instanceof LetUser) {

			if(arg1.getObject() instanceof Integer){
				return -1;
			}
			else if(arg1.getObject() instanceof String){
				return -1;
			}
			else if(arg1.getObject() instanceof LetUser){
				return   ((LetUser) argo.getObject()).getId()- ((LetUser)arg1.getObject()).getId() ;
			}	
		}
		
		else if(argo.getObject() instanceof String){
			if(arg1.getObject() instanceof String){
				return	((String) argo.getObject()).compareTo((String) arg1.getObject());
			}
			else if(arg1.getObject() instanceof Integer){
				return 1;
			}
			else if(arg1.getObject() instanceof LetUser) {
				return -1;
			}
			return 1;

		}
		
		return 0;
	}
	
}


class CaseThree implements Comparator<Type>{

	@Override
	public int compare(Type argo, Type arg1) {
		
		if(argo.getObject() instanceof Integer){
			if(arg1.getObject() instanceof Integer) {
				
				int i = (int)arg1.getObject();
                int j = (int)argo.getObject();
                return j - i;
            }
            return 1;
			}
		else if(argo.getObject() instanceof LetUser) {

			if(arg1.getObject() instanceof Integer){
				return -1;
			}
			else if(arg1.getObject() instanceof String){
				return ((LetUser) argo.getObject()).getName().compareTo((String)arg1.getObject());
			}
			else if(arg1.getObject() instanceof LetUser){
				return   ((LetUser) argo.getObject()).getId()- ((LetUser)arg1.getObject()).getId() ;
			}	
		}
		
		else if(argo.getObject() instanceof String){
			if(arg1.getObject() instanceof String){
				return	((String) argo.getObject()).compareTo((String) arg1.getObject());
			}
			else if(arg1.getObject() instanceof Integer){
				return -1;
			}
			else if(arg1.getObject() instanceof LetUser) {
				return ((String) argo.getObject()).compareTo(((LetUser) arg1.getObject()).getName());
			}
			return 0;

		}
		
		return 0;
	}
	
}



















