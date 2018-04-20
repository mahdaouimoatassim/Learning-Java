/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_8_new_features;
import java.time.*;
import java.time.temporal.*;
import static java.time.temporal.TemporalAdjusters.next;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author El Mouatassim Billah
 */
public class DateTimeExample {
    
    DayOfWeek Today=DayOfWeek.WEDNESDAY;
    static Month ThisMonth=Month.APRIL;
    
    
    /**
     * Fonction qui permet d'afficher un instant de temps selon les différents zonos geographique
     * 
     * @param instant  represente un instant de temps
     */
    public static void InstantTimeZone(Instant instant)
    {
        
    ZoneId.SHORT_IDS.entrySet().stream()
            .sorted((Map.Entry<String,String> ent1, Map.Entry<String,String> ent2)-> 
            { String[] Value1= ent1.getValue().split("/");
               String[] Value2= ent2.getValue().split("/");  
            return (Value2[0].length() - Value1[0].length()==0) ? Value2[0].length() - Value1[0].length(): Value2[0].compareTo(Value1[0]);
            }  )
            .forEach((entrySet) -> {
                    
        System.out.println(ZonedDateTime.ofInstant(instant, ZoneId.of(entrySet.getValue())));
        
        });
    
    }
    /**
     * Fonction qui permet d'afficher l'age d'une personne en année, mois et jours
     * 
     * @param BirthDay La date de naissance de la personne
     * @return une period 
     */
    public static Period AgePerson(LocalDate BirthDay)
    {
        Period age=Period.between(BirthDay, LocalDate.now());
        System.out.println("La persone a vivait : "+age.getYears()+" ans , "+age.getMonths()+" mois et "+age.getDays()+" Jours.\n");
    return age;
    }
   /**
    * Fonction Qui represente le nombre de jours de type DayOfWeek que la personne a vivait
    * 
    * @param LocalDate
    * @param DayOfWeek
    */
    public static long NB_Jours_DayOfWeek(LocalDate BirthDay,DayOfWeek DoW)
    {
    
        return  ChronoUnit.DAYS.between(BirthDay.with(next(DoW)), LocalDate.now()) / 7; 
    }
    
    
    /**
     * 
     * @param args 
     */
    
    
    public static void main(String[] args)
    {
    
    
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.HOUR, 8);
    cal.getTime(); // actually returns a Date
   
    LocalTime now = LocalTime.MIDNIGHT;               System.out.println(now);
    LocalTime now2 = LocalTime.NOON;                  System.out.println(now2);
    LocalTime now3 = LocalTime.of(15, 54, 30);        System.out.println(now3);  
    LocalTime now4 = LocalTime.ofSecondOfDay(15000);  System.out.println(now4);
    LocalTime now5 = LocalTime.parse("15:30:25");     System.out.println(now5);
    LocalTime later = now.plusHours(12);              System.out.println(later);

    LocalDate today = LocalDate.now();                      System.out.println(today);
    LocalDate today1 = LocalDate.MAX;                       System.out.println(today1);
    LocalDate today2 = LocalDate.MIN;                       System.out.println(today2);
    LocalDate today3 = LocalDate.of(2018, ThisMonth, 12);   System.out.println(today3);
    LocalDate today4 = LocalDate.ofYearDay(2015, 64);       System.out.println(today4);
    LocalDate today5 = LocalDate.parse("2018-12-03");       System.out.println(today5);
    LocalDate thirtyDaysFromNow = today.plusDays(30);       System.out.println(thirtyDaysFromNow);
    LocalDate nextMonth = today.plusMonths(1);              System.out.println(nextMonth);
    LocalDate aMonthAgo = today.minusMonths(1);             System.out.println(aMonthAgo);
    
    LocalDateTime ThisTime=LocalDateTime.now();                             System.out.println(ThisTime);
    LocalDateTime ThisTime2=LocalDateTime.of(2018, 11, 25, 14, 32, 23);     System.out.println(ThisTime2);
    LocalDateTime ThisTime3=LocalDateTime.parse("2015-11-25T14:32:23");     System.out.println(ThisTime3);

    
    Period  Period1=Period.between(LocalDate.now(), LocalDate.now().plusMonths(2));     System.out.println(Period1);
    Period  Period2=Period.of(00, 15, 25);                                              System.out.println(Period2);
    Period  Period3=Period.ofWeeks(2);                                                  System.out.println(Period3);
    Period  Period4 =Period.parse("P1Y12M24D");                                           System.out.println(Period4);
System.out.println("-------------------------");
    System.out.println(Period2.negated());
    System.out.println(Period2.normalized());  
    
    Duration duration1=Duration.ofDays(12);                     System.out.println(duration1);
    Duration duration2=Duration.ofHours(54);                    System.out.println(duration2);
    Duration duration3=Duration.ofMillis(123546);               System.out.println(duration3);
    Duration duration4=Duration.ofSeconds(12145);               System.out.println(duration4);
    Duration duration5=Duration.parse("PT1H2M3.12S");           System.out.println(duration5);
    
    Instant instant=Instant.now();                              System.out.println(instant+"hello");
            
    OffsetDateTime offsetDateTime=OffsetDateTime.now();         System.out.println(offsetDateTime);
            
    ZonedDateTime zonedDateTime=ZonedDateTime.now();            System.out.println(zonedDateTime);
    ZonedDateTime zonedDateTime2=ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Tokyo"));System.out.println(zonedDateTime2);
    System.out.println(zonedDateTime.getOffset()+"\n");
    
    ZoneId mountainTime = ZoneId.of("America/Denver");
   
    // Afficher le temps actuel au niveau de chaque zone dans le monde
      Instant instant5=Instant.now();
      InstantTimeZone(instant5);

    
    //Afficher l'age d'une personne  
        AgePerson(LocalDate.parse("1994-03-10"));
        AgePerson(LocalDate.parse("1965-03-24"));
        AgePerson(LocalDate.parse("1960-11-18"));
        AgePerson(LocalDate.parse("1995-07-18"));
        AgePerson(LocalDate.parse("2001-02-08"));
        AgePerson(LocalDate.parse("2003-08-03"));
        
     
        
       LocalDate d=LocalDate.now();
        
    }
    
}
