package Obserwator;
import Uczelnia.*;

public interface Obserwowany {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow();
}
