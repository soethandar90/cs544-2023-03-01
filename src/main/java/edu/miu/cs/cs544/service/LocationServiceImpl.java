package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.LocationDTO;
import edu.miu.cs.cs544.model.Location;
import edu.miu.cs.cs544.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LocationDTO findOneLocationByBadgeId(int id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (!optionalLocation.isPresent()) {
            System.err.println("Location not found with id " + id);
        }
        return modelMapper.map(optionalLocation.get(), LocationDTO.class);
    }

    @Override
    public List<LocationDTO> findAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(location -> modelMapper.map(location, LocationDTO.class)).collect(Collectors.toList());

    }

    @Override
    public Location addOneLocation(Location location) {
       return locationRepository.save(location);
    }

    @Override
    public Location updateOneLocation(int locationId, Location location) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if (!optionalLocation.isPresent()) {
            System.err.println("Location not found with id " + locationId);
        }
        Location existingLocation = optionalLocation.get();

        // Update the existing location with the new data
        existingLocation.setLocationName(location.getLocationName());
        existingLocation.setDescription(location.getDescription());
        existingLocation.setLocationType(location.getLocationType());
        existingLocation.setCapacity(location.getCapacity());
        return locationRepository.save(existingLocation);
    }

    @Override
    public List<Location> findAllLocationOfOnePlanByPlanId(int id) {
        return locationRepository.findLocationsOfOnePlanByPlanId(id);
    }

    @Override
    public void deleteOneLocationByLocationId(int id) {
        locationRepository.deleteById(id);
    }


}


//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public UserDTO createUser(UserDTO userDto) {
//        User user = modelMapper.map(userDto, User.class);
//        user = userRepository.save(user);
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    @Override
//    public UserDTO getUserById(Long id) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        return optionalUser.map(user -> modelMapper.map(user, UserDTO.class)).orElse(null);
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> userList = userRepository.findAll();
//        return userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDTO updateUser(Long id, UserDTO userDto) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            user.setName(userDto.getName());
//            user.setEmail(userDto.getEmail());
//            user = userRepository.save(user);
//            return modelMapper.map(user, UserDTO.class);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//}


