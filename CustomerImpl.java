import java.util.ArrayList;

public class CustomerImpl implements CustomerRepository{
    protected static ArrayList<Appointment> appointments = new ArrayList<>();

    /*@Override
    public boolean */
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    public void deleteAppointment(){

    }
    public void makeChangesInAppointment(){

    }

}
