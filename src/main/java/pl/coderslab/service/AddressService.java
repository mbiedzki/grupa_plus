package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Address;
import pl.coderslab.repository.AddressRepository;

import java.util.List;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.delete(id);
    }

    public Address findOne(Long id) {
        return addressRepository.findOne(id);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}
