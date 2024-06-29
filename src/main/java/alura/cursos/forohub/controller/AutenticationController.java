package alura.cursos.forohub.controller;

import alura.cursos.forohub.domain.user.User;
import alura.cursos.forohub.infra.security.DTOAuthetication;
import alura.cursos.forohub.infra.security.DTOJWTToken;
import alura.cursos.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid DTOAuthetication dtoAuthetication){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dtoAuthetication.username(), dtoAuthetication.password());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var JWTToken = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new DTOJWTToken(JWTToken));
    }
}
