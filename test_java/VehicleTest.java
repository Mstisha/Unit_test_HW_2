import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleTest {

    Car car = new Car("Nissan", "Qashqai", 2022);
    Motorcycle moto = new Motorcycle("Ducati", "Monster", 2021);

    //- ïðîâåðêà òîãî, ÷òî ýêçåìïëÿð îáúåêòà Car òàêæå ÿâëÿåòñÿ ýêçåìïëÿðîì òðàíñïîðòíîãî ñðåäñòâà; (instanceof)
    @Test
    void instanceOf() {
        //Car car = new Car("Nissan", "Qashqai", 2022);
        assertThat(car instanceof Vehicle);
    }

    //- ïðîâåðêà òîãî, îáúåêò Car ñîçäàåòñÿ ñ 4-ìÿ êîëåñàìè
    @Test
    void WheelsCar() {
        //Car car = new Car("Nissan", "Qashqai", 2022);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // - ïðîâåðêà òîãî, îáúåêò Motorcycle ñîçäàåòñÿ ñ 2-ìÿ êîëåñàìè
    @Test
    void MotorcycleWheels() {
        //Motorcycle moto = new Motorcycle("Ducati", "Monster", 2021);
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    //- ïðîâåðêà òîãî, îáúåêò Car ðàçâèâàåò ñêîðîñòü 60 â ðåæèìå òåñòîâîãî âîæäåíèÿ (testDrive())
    @Test
    void testDriveCar() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // - ïðîâåðêà òîãî, îáúåêò Motorcycle ðàçâèâàåò ñêîðîñòü 75 â ðåæèìå òåñòîâîãî âîæäåíèÿ (testDrive())
    @Test
    void testDriveMotorcycle() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    //- ïðîâåðèòü, ÷òî â ðåæèìå ïàðêîâêè (ñíà÷àëà testDrive, ïîòîì park,
    // ò.å ýìóëÿöèÿ äâèæåíèÿ òðàíñïîðòà) ìàøèíà îñòàíàâëèâàåòñÿ (speed = 0)
    @Test
    void parkCar() {
        car.testDrive();
        //System.out.println(car.getSpeed());
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //- ïðîâåðèòü, ÷òî â ðåæèìå ïàðêîâêè (ñíà÷àëà testDrive, ïîòîì park
    // ò.å ýìóëÿöèÿ äâèæåíèÿ òðàíñïîðòà) ìîòîöèêë îñòàíàâëèâàåòñÿ (speed = 0)
    @Test
    void parkMotorcycle() {
        moto.testDrive();
        //System.out.println(moto.getSpeed());
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }

}