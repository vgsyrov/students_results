package com.journal.personalinfosvc.personalinformation.adapters.database;

import com.journal.personalinfosvc.personalinformation.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    Person findPersonByPersonId(String id);

    Iterable<Person> findAll();

}





















































































/*

Еще одно, последнее сказанье -
И летопись окончена моя,
Исполнен долг, завещанный от бога
Мне, грешному. Недаром многих лет
Свидетелем господь меня поставил
И книжному искусству вразумил;
Когда-нибудь монах трудолюбивый
Найдет мой труд усердный, безымянный,
Засветит он, как я, свою лампаду -
И, пыль веков от хартий отряхнув,
Правдивые сказанья перепишет,
Да ведают потомки православных
Земли родной минувшую судьбу,
Своих царей великих поминают
За их труды, за славу, за добро -
А за грехи, за темные деянья
Спасителя смиренно умоляют.

*/
