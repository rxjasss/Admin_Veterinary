package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	private static final String USER_VIEW = "users";
	private static final String FORM_VIEW = "formUsers";
	private static final String FORM_PASSWORD_VIEW = "formPasswordUsers";

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	// Metodo para listar usuarios
	@GetMapping("/listUsers")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView(USER_VIEW);
		mav.addObject("users", userService.listAllUsers());
		return mav;
	}

	// Metodo para crear/editar un usuario
	@PostMapping("/addVeterinary")
	public String addVeterinary(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			RedirectAttributes flash, Model model) {
		if (user.getId() == 0) {
			User userExist = userService.registerVeterinary(user);
			if (userExist != null) {
				flash.addFlashAttribute("success", "Veterinary created successfully");

			} else {
				flash.addFlashAttribute("error", "Username already exists");
				return "redirect:/users/formUser?error";
			}

		} else {
			userService.updateUser(user);
			if (user.getRole().equals("ROLE_USER"))
				flash.addFlashAttribute("success", "User updated successfully");
			else
				flash.addFlashAttribute("success", "Veterinary updated successfully");
		}
		return "redirect:/users/listUsers";

	}
	
	// Metodo para crear/editar un usuario sin contraseña
		@PostMapping("/addVeterinaryWithoutPass")
		public String addVeterinaryWithoutPass(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
				RedirectAttributes flash, Model model) {
			if (user.getId() == 0) {
				User userExist = userService.registerVeterinary(user);
				if (userExist != null) {
					flash.addFlashAttribute("success", "Veterinary created successfully");

				} else {
					flash.addFlashAttribute("error", "Username already exists");
					return "redirect:/users/formUser?error";
				}

			} else {
				userService.updateUserWithoutPass(user);
				if (user.getRole().equals("ROLE_USER"))
					flash.addFlashAttribute("success", "User updated successfully");
				else
					flash.addFlashAttribute("success", "Veterinary updated successfully");
			}
			return "redirect:/users/listUsers";

		}


	// Metodo para borrar usuarios
	@GetMapping("/deleteUser/{id}")
	public String removeUser(@PathVariable("id") int id, RedirectAttributes flash) {
		User a = userService.findUserId(id);
		try {
			userService.deleteUser(a.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flash.addFlashAttribute("success", "User deleted successfully");

		return "redirect:/users/listUsers";
	}

	@GetMapping(value = { "/formUser", "/formUser/{username}"})
	public String formUser(@PathVariable(name = "username", required = false) String username, Model model) {
		if (username != null) {
			model.addAttribute("user", userService.findUser(username));

		} else {
			model.addAttribute("user", new User());
		}

		return FORM_VIEW;
	}
	
	@GetMapping(value = { "/formPasswordUser/{username}" })
	public String formPasswordUser(@PathVariable(name = "username", required = false) String username, Model model) {
		if (username != null) {
			model.addAttribute("user", userService.findUser(username));

		} else {
			model.addAttribute("user", new User());
		}

		return FORM_PASSWORD_VIEW;
	}

	// Metodo de activar/desactivar usuarios
	@GetMapping("/activateUser/{username}")
	public String activate(@PathVariable("username") String username, RedirectAttributes flash) {
		int i = userService.activate(username);
		if (i == 1) {
			flash.addFlashAttribute("success", "User activate successfully");

		} else if (i == 0) {
			flash.addFlashAttribute("success", "User deactivate successfully");

		} else
			flash.addFlashAttribute("error", "User cant be activate/deactivate");

		return "redirect:/users/listUsers";
	}

	// Metodo redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/alumnos/listUsers");
	}

}
