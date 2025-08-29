package co.com.crediya.usecase.user;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthAuthUserUseCaseTest {

    /*@Mock
    private UserRepository repository;

    @Mock
    private PasswordService passwordService;

    private User user;
    private UserUseCase userUseCase;

    @BeforeEach
    void setup(){
        user = User.builder()
                .id(null)
                .document_number("123456789")
                .first_name("John")
                .last_name("Doe")
                .birth_date(LocalDate.of(1995, 5, 20))
                .address("123 Main St")
                .phone("+1234567890")
                .email("john2.doe@example.com")
                .base_salary(BigDecimal.valueOf(1400000))
                .password("123456")
                .role_id("ADMIN")
                .build();
        userUseCase = new UserUseCase(repository, passwordService);
    }

    @Test
    void shouldRegisterUser_whenEmailNotExists() {
        when(repository.findByEmail(user.getEmail())).thenReturn(Mono.just(false));
        when(repository.registerUser(user)).thenReturn(Mono.empty());
        StepVerifier.create(userUseCase.registerUser(user)).verifyComplete();
        verify(repository).registerUser(user);
    }

    @Test
    void shouldThrowError_whenEmailAlreadyExists() {
        when(repository.findByEmail(user.getEmail())).thenReturn(Mono.just(true));
        StepVerifier.create(userUseCase.registerUser(user))
                .expectErrorMatches(throwable ->
                        throwable instanceof ValidationException &&
                                ((ValidationException) throwable).getErrors() != null &&
                                ((ValidationException) throwable).getErrors().contains("El correo electrónico ya está registrado")
                )
                .verify();

        verify(repository, never()).registerUser(any());
    }*/
}
