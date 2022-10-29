package kodlama.io.kodlama.io.Devs.dataAccess.consretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;


@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	private List<Language> languages = new ArrayList<>();
	
	public InMemoryLanguageRepository() {
		
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "JavaScript"));
		languages.add(new Language(4, "GoLang"));
		languages.add(new Language(5, "C++"));
		languages.add(new Language(6, "Python"));
		languages.add(new Language(7, "Swift"));
	}

	@Override
	public List<Language> getAll() {		
		return languages;
	}


	@Override
	public Language add(Language language) {
		languages.add(language);
		return getById(language.getId());
	}

	@Override
	public void update(Language language, int id) {
		Language language2 = getById(id);
		language2.setName(language.getName());		
	}

	@Override
	public void delete(int id) {
		languages.remove(id);		
	}

	@Override
	public Language getById(int id) {
		return languages.stream().filter(language -> language.getId()==id).findFirst().get();
	}

} 