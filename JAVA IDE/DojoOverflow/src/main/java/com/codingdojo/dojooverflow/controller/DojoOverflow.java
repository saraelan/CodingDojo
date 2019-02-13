
package com.codingdojo.dojooverflow.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
@RequestMapping("/")
public class DojoOverflow {
	
	private QuestionService questionService;
	private TagService tagService;
	private AnswerService answerService;
	
	public DojoOverflow(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}

	@GetMapping("questions")
	public String dashboard(Model model) {
		List<Question> questionList = questionService.allQuestions();
		model.addAttribute("questionList", questionList);
		return "dashboard";
	}
	
	@GetMapping("questions/new")
	public String newQuestion(
			@ModelAttribute("errors") String errors,
			@ModelAttribute("q") Question question,
			Model model) {
		model.addAttribute("errors", errors);
		return "newquestion.jsp";
	}
	
	@PostMapping("questions/new")
	public String createQuestion(
			@Valid @ModelAttribute("q") Question question,
			BindingResult result,
			@RequestParam(value="tagsStr") String tagsStr,
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "newquestion.jsp";
		} else if (tagsStr.length() < 1) {
			redirectAttributes.addFlashAttribute("errors", "Tags cannot be blank!");
			return "redirect:/questions/new";
		} else {
			questionService.addQuestion(question);
			List<Tag> questionTags = new ArrayList<Tag>();
			String[] tagsArr = tagsStr.split(", ");
			for (int i = 0; i < tagsArr.length; i++) {
				Tag tag = tagService.findTagBySubject(tagsArr[i]);
				if (tag != null) {
					questionTags.add(tag);
				} else {
					questionTags.add(new Tag(tagsArr[i]));
				}
			}
			question.setTags(questionTags);
			questionService.updateQuestion(question);
			return "redirect:/questions/" + question.getId();
		}
	}
	
//	@GetMapping("questions/{id}")
//	public String questionProfile(
//			@PathVariable("id") Long id,
//			@ModelAttribute("a") Answer answer,
//			Model model) {
//		Question question = questionService.findQuestionById(id);
//		model.addAttribute("question", question);
//		model.addAttribute("answers", answerService.getAnswersForQuestion(question));
//		return "questionprofile.jsp";
//	}
	
//	@PostMapping("questions/{id}")
//	public String addAnswerToQuestion(
//			@PathVariable("id") Long id,
//			@Valid @ModelAttribute("a") Answer answer,
//			BindingResult result,
//			Model model) {
//		Question question = questionService.findQuestionById(id);
//		model.addAttribute("question", question);
//		model.addAttribute("answers", answerService.getAnswersForQuestion(question));
//		if (result.hasErrors()) {
//			return "questionprofile.jsp";
//		} else {
//			answerService.addAnswer(answer);
//			return "redirect:/questions/" + id;
//		}
//	}
}
