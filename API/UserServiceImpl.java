/**
 * The {@code UserServiceImpl} class implements the {@link UserService} interface
 * and provides functionality related to user management and authentication.
 * It is annotated with {@link Service} for Spring service component.
 *
 * @author Team1
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * The repository for user-related operations.
     */
    private UserRepository userRepository;

    /**
     * The password encoder for securing user passwords.
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor for the {@code UserServiceImpl} class.
     *
     * @param userRepository The repository for user-related operations.
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a new user based on the provided registration data.
     *
     * @param registrationDto The data for user registration.
     * @return The saved user entity.
     */
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                registrationDto.getPhoneNo(),
                registrationDto.getEducationLevel(),
                Arrays.asList(new Role("ROLE_USER"))
        );

        return userRepository.save(user);
    }

    /**
     * Loads a user by the provided username for authentication purposes.
     *
     * @param username The username of the user to be loaded.
     * @return UserDetails representing the loaded user.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    /**
     * Maps user roles to Spring Security authorities.
     *
     * @param roles The roles assigned to the user.
     * @return A collection of Spring Security GrantedAuthority objects.
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
