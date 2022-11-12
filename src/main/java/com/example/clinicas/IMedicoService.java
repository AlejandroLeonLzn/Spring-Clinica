
package com.example.clinicas;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    //CRUD con funcion
    public List<Medico>listar();//mostrar
    public Optional<Medico>ListarId(int id);//editar lista
    public int save(Medico p);//guardar
    public void delete (int id);//eliminar
}
