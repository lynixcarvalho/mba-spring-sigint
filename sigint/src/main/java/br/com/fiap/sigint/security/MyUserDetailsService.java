package br.com.fiap.sigint.security;

import br.com.fiap.sigint.entity.CartaoEntity;
import br.com.fiap.sigint.repository.CartaoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private CartaoRepository cartaoRepository;

    public MyUserDetailsService(CartaoRepository cartaoRepository){
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String Cartao) throws UsernameNotFoundException {
        Long numeroCartao = Long.parseLong(Cartao);
        CartaoEntity cartaoEntity = cartaoRepository.findByCartao(numeroCartao);

        if(cartaoEntity == null){
            System.out.println("cartao entity "+numeroCartao+" not found");
            throw new UsernameNotFoundException("Cartão "+numeroCartao+" not found");
            
        }
        System.out.println("passou do loadUserByUsername");
        return new User(
                Cartao,
                cartaoEntity.getSenha(),
                new ArrayList<>() // Roles
        );
    }
}