package az.ematrix.matrix154springlearning.service;

import az.ematrix.matrix154springlearning.dao.PersonDao;
import az.ematrix.matrix154springlearning.dto.PersonDto;
import az.ematrix.matrix154springlearning.repository.StudentsRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentsService {


    public StudentsService(StudentsRepository repository) {
        this.repository = repository;
    }

    private final StudentsRepository repository;

    public PersonDao save(PersonDto dto) {
        log.info("Person will be saved to db {}", dto);

        PersonDao personDaoBuilder = PersonDao.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
        PersonDao savedPerson = repository.save(personDaoBuilder);

        log.info("Person saved: {}", savedPerson);

        return savedPerson;
    }

    public ArrayList<PersonDto> getAll() {
        int a = 5;
        ArrayList<PersonDao> all = repository.findAllByIdGreaterThan(a);

        log.info("Retrieved {} persons with ID greater than {}", all.size(), a);
        List<PersonDao> productsAbovePriceNative = repository.findProductsAbovePriceNative(a);

        log.info("Retrieved {} persons above price using native query",
                productsAbovePriceNative.size());
        ArrayList<PersonDto> personDtos = new ArrayList<>();

        for (PersonDao personDao : all) {
            PersonDto personDto = PersonDto.builder()
                    .name(personDao.getName())
                    .surname(personDao.getSurname())
                    .build();
            personDtos.add(personDto);
        }

        return personDtos;
    }

    public PersonDto get(Long id) {
        PersonDao personDao = repository.findById(id).orElse(null);
        if (personDao != null) {
            log.info("Retrieved person with ID {}: {}", id, personDao);
        } else {
            log.warn("Person with ID {} not found", id);
        }
        return PersonDto.builder()
                .name(personDao != null ? personDao.getName() : null)
                .surname(personDao != null ? personDao.getSurname() : null)
                .build();
    }

    public PersonDto update(String name, Long id) {
        PersonDao personDao = repository.findById(id).orElse(null);
        if (personDao != null) {
            personDao.setName(name);

            PersonDao saved = repository.save(personDao);
            log.info("Updated person with ID {}: {}", id, saved);

            return PersonDto.builder()
                    .name(saved.getName())
                    .surname(saved.getSurname())
                    .build();
        } else {
            log.warn("Person with ID {} not found, update failed", id);
            return null;
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
        log.info("Deleted person with ID: {}", id);
    }

}
