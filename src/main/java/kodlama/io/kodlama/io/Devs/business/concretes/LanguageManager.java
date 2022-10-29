package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;


@Service
public class LanguageManager implements LanguageService {	
	private LanguageRepository languageRepository;		
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}		
	
	@Override
	public List<Language> getAll() {		
		return languageRepository.getAll();
	}

	
	@Override
	public Language add(Language language) throws Exception {
		
		if (isIdExist(language.getId())) throw new Exception("İd tekrar edemez!");
		if (isNameExist(language)) throw new Exception("İsim tekrar edemez!");
		
		return languageRepository.add(language);
	}
	

	@Override
	public void update(Language language, int id) throws Exception {
		
		if(!isIdExist(language.getId())) throw new Exception("Id Bulunamadı!");
		if(!isNameExist(language)) throw new Exception("İsim tekrar edemez!");
		
		languageRepository.update(language, id);		
	}

	@Override
	public void delete(int id) throws Exception{
		
		if(!isIdExist(id)) throw new Exception("Id bulunamadı!");
		languageRepository.delete(id);		
	}

	@Override
	public Language getById(int id) throws Exception {
		
		if(!isIdExist(id)) throw new Exception("Id bulunamadı!");
		
		return languageRepository.getById(id);
	}	
	
	
	//--------------------------------------------------------
	
	private boolean isNameExist(Language language) {
		
		for(Language language2: getAll()) {
			if(language.getName().equals(language2.getName())) {
				return true;
			}
		}		
		return false;
	}


	private boolean isIdExist(int id) {
		
		for (Language language2 : getAll()) {
			if (language2.getId() == id) {
				return true;
			}
		}
		return false;
	}
	

}
