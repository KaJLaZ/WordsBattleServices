package mvc.controllers;

import mvc.core.Game;
import mvc.core.WordsField;
import mvc.services.GameEndCheckService;
import mvc.services.GameInitializerService;
import mvc.services.WordVerificationService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ClientController {
	@Autowired
	GameInitializerService gameInitializerService;
	@Autowired
	WordVerificationService wordVerificationService;
	@Autowired
	GameEndCheckService gameEndCheckService;

	private Game game;

	@GetMapping("/startGame")
	public ResponseEntity<WordsField> startGame(){
		game = gameInitializerService.initialize();
		return ResponseEntity.ok(game.getWordsField());
	}

	@PostMapping("/wordVerification")
	public ResponseEntity<Boolean> wordVerification(String word){
		boolean result = wordVerificationService.isCorrect(word);

		gameEndCheckService.clientAnswerProcess(game, result);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/isGameEnd")
	public ResponseEntity<Boolean> isGameEnd(){
		return ResponseEntity.ok(gameEndCheckService.isGameEnd(game));
	}

}
