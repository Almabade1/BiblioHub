package com.bezkoder.spring.thymeleaf;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bezkoder.spring.thymeleaf.controller.TutorialController;
import com.bezkoder.spring.thymeleaf.entity.Tutorial;
import com.bezkoder.spring.thymeleaf.repository.TutorialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TutorialControllerTests {

    @Mock
    private TutorialRepository tutorialRepository;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private TutorialController tutorialController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll_NoKeyword() {
        List<Tutorial> tutorials = new ArrayList<>();
        Tutorial tutorial = new Tutorial();
        tutorial.setId(1);
        tutorial.setTitle("Test Tutorial");
        tutorial.setDescription("Description");
        tutorial.setPublished(true);
        tutorials.add(tutorial);

        when(tutorialRepository.findAll()).thenReturn(tutorials);

        String view = tutorialController.getAll(model, null);

        verify(tutorialRepository, times(1)).findAll();
        verify(model, times(1)).addAttribute("tutorials", tutorials);
        assertEquals("tutorials", view);
    }

    @Test
    void testGetAll_WithKeyword() {
        String keyword = "Test";
        List<Tutorial> tutorials = new ArrayList<>();
        Tutorial tutorial = new Tutorial();
        tutorial.setId(1);
        tutorial.setTitle("Test Tutorial");
        tutorial.setDescription("Description");
        tutorial.setPublished(true);
        tutorials.add(tutorial);

        when(tutorialRepository.findByTitleContainingIgnoreCase(keyword)).thenReturn(tutorials);

        String view = tutorialController.getAll(model, keyword);

        verify(tutorialRepository, times(1)).findByTitleContainingIgnoreCase(keyword);
        verify(model, times(1)).addAttribute("tutorials", tutorials);
        verify(model, times(1)).addAttribute("keyword", keyword);
        assertEquals("tutorials", view);
    }

    @Test
    void testAddTutorial() {
        String view = tutorialController.addTutorial(model);

        verify(model, times(1)).addAttribute(eq("tutorial"), any(Tutorial.class));
        verify(model, times(1)).addAttribute("pageTitle", "Crear Lista");
        assertEquals("tutorial_form", view);
    }

    @Test
    void testSaveTutorial() {
        Tutorial tutorial = new Tutorial();
        tutorial.setId(1);
        tutorial.setTitle("New Tutorial");
        tutorial.setDescription("Description");
        tutorial.setPublished(true);

        String view = tutorialController.saveTutorial(tutorial, redirectAttributes);

        verify(tutorialRepository, times(1)).save(tutorial);
        verify(redirectAttributes, times(1)).addFlashAttribute("message", "El Libro se ha guardado exitosamente!");
        assertEquals("redirect:/Libros", view);
    }

    @Test
    void testEditTutorial() {
        int id = 1;
        Tutorial tutorial = new Tutorial();
        tutorial.setId(1);
        tutorial.setTitle("Test Tutorial");
        tutorial.setDescription("Description");
        tutorial.setPublished(true);

        when(tutorialRepository.findById(id)).thenReturn(Optional.of(tutorial));

        String view = tutorialController.editTutorial(id, model, redirectAttributes);

        verify(tutorialRepository, times(1)).findById(id);
        verify(model, times(1)).addAttribute("tutorial", tutorial);
        verify(model, times(1)).addAttribute("pageTitle", "Editar Libro (ID: 1)");
        assertEquals("tutorial_form", view);
    }

    @Test
    void testDeleteTutorial() {
        int id = 1;

        String view = tutorialController.deleteTutorial(id, model, redirectAttributes);

        verify(tutorialRepository, times(1)).deleteById(id);
        verify(redirectAttributes, times(1)).addFlashAttribute("message", "El libro con id=" + id + " ha sido eliminado exitosamente!");
        assertEquals("redirect:/Libros", view);
    }

    @Test
    void testUpdatePublishedStatus() {
        int id = 1;
        boolean published = true;

        String view = tutorialController.updateTutorialPublishedStatus(id, published, model, redirectAttributes);

        verify(tutorialRepository, times(1)).updatePublishedStatus(id, published);
        verify(redirectAttributes, times(1)).addFlashAttribute("message", "Se añadió stock del libro id=" + id);
        assertEquals("redirect:/Libros", view);
    }
}
