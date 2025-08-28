package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.PasswordService;
import co.com.crediya.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository repository;
    private final PasswordService passwordService;

    public Mono<Void> authenticateUser(User user){
        /*return roleRepository.findRoleByName(user.getRole())
                .switchIfEmpty(Mono.error(new ValidationException(
                        List.of("El rol '" + user.getRole() + "' es incorrecto o no existe en la base de datos.")
                )))
                .then(repository.findByEmail(user.getEmail()))
                .flatMap(emailExists -> {
                    if (emailExists) {
                        return Mono.error(new ValidationException(
                                List.of("El correo electrónico ya está registrado")
                        ));
                    }

                    user.setPassword(passwordService.encode(user.getPassword()));
                    return repository.registerUser(user).then();
                });*/
        return null;


    }

    public String test(){
        return "Hello!!! GONZA!!!";
    }
}
