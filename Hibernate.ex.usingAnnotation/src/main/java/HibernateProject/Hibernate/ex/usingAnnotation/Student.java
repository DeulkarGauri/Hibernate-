package HibernateProject.Hibernate.ex.usingAnnotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
     private int id;
	
     private String Name;
     
     private String City;

         public Student(int id, String name, String city) {
             super();
             this.id = id;
             Name = name;
             City = city;
             }

         public int getId() {
             return id;
             }

         public void setId(int id) {
             	this.id = id;
         }

         public String getName() {
             return Name;
             }

         public void setName(String name) {
             	Name = name;
                }

         public String getCity() {
             	return City;
                }

         public void setCity(String city) {
             	City = city;
            }

		@Override
		public String toString() {
			return this.id +" : "+this.Name +" : "+this.City;
		}


         }
