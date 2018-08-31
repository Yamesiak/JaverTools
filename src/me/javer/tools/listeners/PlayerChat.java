package me.javer.tools.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import me.javer.tools.Main;
import me.javer.tools.objects.Chat;
import me.javer.tools.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener{
	
	final HashMap<Player, Boolean> muted;
	private ArrayList<String> slowdown;
	
	public static final Pattern URL_PATTERN = Pattern.compile("((?:(?:https?)://)?[\\w-_\\.]{2,})\\."
			+ "([a-zA-Z]{2,3}(?:/\\S+)?)");
	
	public static final Pattern IPPATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\"
			+ "d\\d?|2[0-4]\\d|25[0-5])"
			+ "\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	public static final Pattern BANNED_WORDS = Pattern.compile(".*(skkf|ragemc|xnice|mchc|xcrafters|xbcmc|ssij|"
			+ "lifehard|trollcraft|mcwg|doscraft|xkleszcz|craftstory|face2face|f2f|2/10|lagi|"
			+ "gale|algi|chuj|chuja|chujek|chuju|chujem|chujnia|chujowy|chujowa|chujowe|cipa|"
			+ "cipe|cipie|dojebac|dojebie|dojebal|dojebala|dojebalem|dojebalam|dojebie|dopieprzac|"
			+ "dopierdalac|dopierdala|dopierdalal|dopierdalala|dopierdoli|dopierdolil|dopierdole|"
			+ "dopierdoli|dopierdalajacy|dopierdolic|dupa|dupie|dupcia|dupeczka|dupy|dupe|huj|hujek|"
			+ "hujnia|huja|huje|hujem|huju|jebac|jebal|jebie|jebia|jebak|jebaka|jebal|jebany|jebane|"
			+ "jebanka|jebanko|jebankiem|jebanymi|jebana|jebanym|jebanej|jebana|jebani|jebanych|"
			+ "jebanymi|jebcie|jebiacy|jebiaca|jebiacego|jebiacej|jebia|jebie|jebliwy|jebnac|jebnal|"
			+ "jebna|jebnela|jebnie|jebnij|jebut|koorwa|korwa|kurestwo|kurew|kurewski|kurewska|kurewskiej|"
			+ "kurewska|kurewsko|kurewstwo|kurwa|kurwaa|kurwami|kurwe|kurwie|kurwiska|kurwo|kurwy|kurwach|"
			+ "kurwami|kurewski|kurwiarz|kurwiajacy|kurwica|kurwic|kurwidolek|kurwik|kurwiki|kurwiszcze|"
			+ "kurwiszon|kurwiszona|kurwiszonem|kurwiszony|kutas|kutasa|kutasie|kutasem|kutasy|kutasow|"
			+ "kutasach|kutasami|matkojebca|matkojebcy|matkojebca|matkojebcami|matkojebcach|najebac|najebal|"
			+ "najebane|najebany|najebana|najebie|najebia|naopierdalac|naopierdalal|naopierdalala|napierdalac|"
			+ "napierdalajacy|napierdolic|nawpierdalac|nawpierdalal|nawpierdalala|obsrywac|obsrywajacy|odpieprzac|"
			+ "odpieprzy|odpieprzyl|odpieprzyla|odpierdalac|odpierdol|odpierdolil|odpierdolila|odpierdoli|"
			+ "odpierdalajacy|odpierdalajaca|odpierdolic|odpierdoli|opieprzajacy|opierdalac|opierdala|opierdalajacy|"
			+ "opierdol|opierdolic|opierdoli|opierdola|piczka|pieprzniety|pieprzony|pierdel|pierdlu|pierdola|"
			+ "pierdolacy|pierdolaca|pierdol|pierdole|pierdolenie|pierdoleniem|pierdoleniu|pierdolec|pierdola|"
			+ "pierdolicie|pierdolic|pierdolil|pierdolila|pierdoli|pierdolniety|pierdolisz|pierdolnac|pierdolnal|"
			+ "pierdolnela|pierdolnie|pierdolnij|pierdolnik|pierdolona|pierdolone|pierdolony|pierdzacy|pierdziec|"
			+ "pizda|pizde|pizdzie|pizdnac|pizdu|podpierdalac|podpierdala|podpierdalajacypodpierdolic|podpierdoli|"
			+ "pojeb|pojeba|pojebami|pojebani|pojebanego|myhard|mhard|pojebanemu|pojebani|pojebany|pojebanych|"
			+ "pojebanym|pojebanymi|pojebem|pojebac|pojebalo|popierdala|popierdalac|popierdolic|popierdoli|"
			+ "popierdolonego|popierdolonemu|popierdolonym|popierdolone|popierdoleni|popierdolony|porozpierdala|"
			+ "porozpierdalac|poruchac|przejebane|przejebac|przyjebali|przepierdalac|przepierdala|przepierdalajacy|"
			+ "przepierdalajaca|przepierdolic|przyjebac|przyjebie|przyjebala|przyjebal|przypieprzac|przypieprzajacy|"
			+ "przypieprzajaca|przypierdalac|przypierdala|przypierdoli|przypierdalajacy|przypierdolic|qrwa|rozjebac|"
			+ "rozjebie|rozjebała|rozpierdalac|rozpierdala|rozpierdolic|rozpierdole|rozpierdoli|rozpierducha|skurwiel|"
			+ "skurwiela|skurwielem|skurwielu|skurwysyn|skurwysynow|skurwysyna|skurwysynem|skurwysynu|skurwysyny|"
			+ "skurwysynski|skurwysynstwo|spieprzac|spieprza|spieprzaj|spieprzajcie|spieprzaja|spieprzajacy|"
			+ "spieprzajaca|spierdalac|spierdala|spierdalal|spierdalalcie|spierdalala|spierdalajacy|spierdolic|"
			+ "spierdoli|spierdolą|spierdola|srac|srajacy|srajac|sraj|sukinsyn|sukinsyny|sukinsynom|sukinsynowi|"
			+ "sukinsynow|ujebac|ujebal|ujebana|ujebany|ujebie|ujebala|ujebala|upierdalac|upierdala|upierdoli|"
			+ "upierdolic|upierdoli|upierdola|upierdoleni|wjebac|wjebie|wjebia|wjebiemy|wjebiecie|wkurwiac|wkurwi|"
			+ "wkurwia|wkurwial|wkurwiajacy|wkurwiajaca|wkurwic|wkurwi|wkurwiacie|wkurwiali|wkurwia|wkurwimy|"
			+ "wkurwicie|wkurwiacie|wkurwic|wkurwia|wpierdalac|wpierdalajacy|wpierdol|wpierdolic|wpizdu|wyjebac|"
			+ "wyjebali|wyjebac|wyjebie|wyjebia|wyjebiesz|wyjebie|wyjebiecie|wyjebiemy|wypieprzac|wypieprza|"
			+ "wypieprzal|wypieprzala|wypieprzy|wypieprzyla|wypieprzyl|wypierdal|wypierdalac|wypierdala|wypierdalaj|"
			+ "wypierdalal|wypierdalala|wypierdolic|wypierdoli|wypierdolimy|wypierdolicie|wypierdola|wypierdolili|"
			+ "wypierdolil|wypierdolila|zajebac|zajebie|zajebia|zajebial|zajebiala|zajebali|zajebana|zajebani|"
			+ "zajebane|zajebany|zajebanych|zajebanym|zajebanymi|zajebiste|zajebisty|zajebistych|zajebista|"
			+ "zajebistym|zajebistymi|zajebiscie|zapieprzyc|zapieprzy|zapieprzyl|zapieprzyla|zapieprza|zapieprz|"
			+ "zapieprzymy|zapieprzycie|zapieprzysz|zapierdala|zapierdalac|zapierdalaja|zapierdalaj|zapierdalajcie|"
			+ "zapierdalala|zapierdalali|zapierdalajacy|zapierdolic|zapierdoli|zapierdolil|zapierdolila|zapierdola|"
			+ "zapierniczac|zapierniczajacy|zasrac|zasranym|zasrywajacy|zesrywac|zesrywajac|zjebac|zjebal|zjebala|"
			+ "zjebana|zjebia|zjebali|zjeby|csrv|mc|pl|eu|com+).*");
	
	public PlayerChat(){
		this.muted = new HashMap<Player, Boolean>();
		this.slowdown = new ArrayList<String>();
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		final Player p = event.getPlayer();
		if(!this.muted.containsKey(p)){
			this.muted.put(p, Boolean.valueOf(false));
		}
		
		if(!p.hasPermission("javertools.bypass")){
			if(Chat.getChat() == false){
				event.setCancelled(true);
				Util.sendMessage(p, "&4Blad: &cChat jest aktualnie wylaczony!");
				return;
			}
			
			if(URL_PATTERN.matcher(event.getMessage()).find()){
				event.setCancelled(true);
				Util.sendMessage(p, "&4Blad: &cWykryto w twojej wiadomosci tekst, ktory narusza regulamin!");
				return;
			}
			if(IPPATTERN.matcher(event.getMessage()).find()){
				event.setCancelled(true);
				Util.sendMessage(p, "&4Blad: &cWykryto w twojej wiadomosci tekst, ktory narusza regulamin!");
				return;
			}
			if(BANNED_WORDS.matcher(event.getMessage()).find()){
				event.setCancelled(true);
				Util.sendMessage(p, "&4Blad: &cWykryto w twojej wiadomosci tekst, ktory narusza regulamin!");
				return;
			}
			if(this.slowdown.contains(p.getName())){
				event.setCancelled(true);
				Util.sendMessage(p, "&4Blad: &cNa czacie mozna pisac co 5 sekund!");
			} else {
				this.slowdown.add(p.getName());
				Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						PlayerChat.this.slowdown.remove(p.getName());
						
					}
				}, 5 * 20L);
			}
		}
	}

}
