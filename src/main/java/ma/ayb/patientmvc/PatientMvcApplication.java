package ma.ayb.patientmvc;

import ma.ayb.patientmvc.entities.Patient;
import ma.ayb.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Ayoub",new Date(),false, 15));
            patientRepository.save(new Patient(null,"Salim",new Date(),true, 25));
            patientRepository.save(new Patient(null,"Nora",new Date(),true, 65));
            patientRepository.save(new Patient(null,"Wiam",new Date(),false, 24));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
