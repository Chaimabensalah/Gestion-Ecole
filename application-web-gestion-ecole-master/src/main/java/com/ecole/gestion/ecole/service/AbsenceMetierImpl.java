package com.ecole.gestion.ecole.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Absence;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;


 

@Service
public class AbsenceMetierImpl implements AbsenceService  {

	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Override
	public long count() {
		return absenceRepository.count();
	}
	@Override
	public void delete(Absence arg0) {
		absenceRepository.delete(arg0);
	}
	@Override
	public void delete(Integer arg0) {
		absenceRepository.delete(arg0);
	}
	@Override
	public void delete(Iterable<? extends Absence> arg0) {
		absenceRepository.delete(arg0);
	}
	@Override
	public void deleteAll() {
		absenceRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return absenceRepository.exists(arg0);
	}

	@Override
	public List<Absence> findAll() {
		return absenceRepository.findAll();
	}

	@Override
	public Iterable<Absence> findAll(Iterable<Integer> arg0) {
		return absenceRepository.findAll(arg0);
	}
	@Override
	public Absence findOne(Integer arg0) {
		return absenceRepository.findOne(arg0);
	}

	@Override
	public <S extends Absence> Iterable<S> save(Iterable<S> arg0) {
		return absenceRepository.save(arg0);
	}

	@Override
	public <S extends Absence> S save(S arg0) {
		return absenceRepository.save(arg0);
	}

	@Override
	public <S extends Absence> S saveAbsence(S arg0,String matriculeEleve,String matiere) {
		arg0.setJustife(false);
		arg0.setEleve(eleveRepository.findByMatricule(matriculeEleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		// sendEmail();
		return absenceRepository.save(arg0);
	}
	
	@Override
	public List<Absence> findParELeve(Eleve eleve) {
		return absenceRepository.findParEleve(eleve);
	}
	@Override
	public List<Absence> findParClasse(String nomclasse) {
		Classe classe=classeRepository.findByNom(nomclasse);
		List<Absence> l= absenceRepository.findParClasse(classe);
		String nomMatiere;
		String neleve;
		for(int i=0;i<l.size();i++)
		{   
			nomMatiere=l.get(i).getMatiere().getNomMatiere();
			l.get(i).setM(nomMatiere);
			
			neleve=l.get(i).getEleve().getNom()+" "+l.get(i).getEleve().getPrenom();
			l.get(i).setE(neleve);
			 
		}
		return l;
	}
 
	
//	private void envoyerMail(String email,String text)
//	   {
//	   	 
//			    	final String username = "example@gmail.com";
//			
//			          final String password = "password";
//			 
//			        Properties props = new Properties();
//			
//			        props.put("mail.smtp.auth", "true");
//			
//			        props.put("mail.smtp.starttls.enable", "true");
//			
//			        props.put("mail.smtp.host", "smtp.gmail.com");
//			
//			        props.put("mail.smtp.port", "587");
//			
//			
//			        Session session = Session.getInstance(props,
//			
//			                new javax.mail.Authenticator() {
//			
//			                    protected PasswordAuthentication getPasswordAuthentication() {
//			
//			                        return new PasswordAuthentication(username, password);
//
//			                    }
//			                });
//			
//			        try {
//			
//			            Message message = new MimeMessage(session);
//			
//			            message.setFrom(new InternetAddress("example@gmail.com"));
//			            message.setRecipients(Message.RecipientType.TO,
//			
//			                    InternetAddress.parse(email));
//			
//			            message.setSubject("Response candidature  amatsamie group");
//			
//			            message.setText( text);
//			
//			            Transport.send(message);
//			
//			            System.out.println("Mail sent succesfully!");
//			
//			        } catch (MessagingException e) {
//			
//			            throw new RuntimeException(e);
//			
//			        }
//			
//			    }
//		     
		      
 
}
