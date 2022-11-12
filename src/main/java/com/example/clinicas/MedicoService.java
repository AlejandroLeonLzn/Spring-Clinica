package com.example.clinicas;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedico data;

    @Override
    public List<Medico> listar() {

        return (List<Medico>) data.findAll();
    }

    @Override
    public Optional<Medico> ListarId(int id) {
       return data.findById(id);
    }

    @Override
    public int save(Medico p) {
        int res=0;
        Medico persona=data.save(p);
        if(!persona.equals(null)){
            res=1;
        }return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

}
