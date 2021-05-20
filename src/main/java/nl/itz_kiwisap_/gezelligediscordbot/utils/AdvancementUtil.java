package nl.itz_kiwisap_.gezelligediscordbot.utils;

import lombok.Getter;

import java.util.HashMap;

public class AdvancementUtil {

    @Getter
    private static final HashMap<String, String> advancements = new HashMap<>();

    static {
        advancements.put("story/mine_stone", "Stone Age");
        advancements.put("story/upgrade_tools", "Getting an Upgrade");
        advancements.put("story/smelt_iron", "Acquire Hardware");
        advancements.put("story/obtain_armor", "Suit Up");
        advancements.put("story/lava_bucket", "Hot Stuff");
        advancements.put("story/iron_tools", "Isn't It Iron Pick");
        advancements.put("story/deflect_arrow", "Not Today, Thank You");
        advancements.put("story/form_obsidian", "Ice Bucket Challenge");
        advancements.put("story/mine_diamond", "Diamonds!");
        advancements.put("story/enter_the_nether", "We Need To Go Deeper");
        advancements.put("story/shiny_gear", "Cover Me With Diamonds");
        advancements.put("story/enchant_item", "Enchanter");
        advancements.put("story/cure_zombie_villager", "Zombie Doctor");
        advancements.put("story/follow_ender_eye", "Eye Spy");
        advancements.put("story/enter_the_end", "The End?");
        advancements.put("nether/return_to_sender", "Return to Sender");
        advancements.put("nether/find_bastion", "Those Were the Days");
        advancements.put("nether/obtain_ancient_debris", "Hidden in the Depths");
        advancements.put("nether/fast_travel", "Subspace Bubble");
        advancements.put("nether/find_fortress", "A Terrible Fortress");
        advancements.put("nether/obtain_crying_obsidian", "Who is Cutting Onions?");
        advancements.put("nether/distract_piglin", "Oh Shiny");
        advancements.put("nether/ride_strider", "This Boat Has Legs");
        advancements.put("nether/uneasy_alliance", "Uneasy Alliance");
        advancements.put("nether/loot_bastion", "War Pigs");
        advancements.put("nether/use_lodestone", "Country Lode, Take Me Home");
        advancements.put("nether/netherite_armor", "Cover Me in Debris");
        advancements.put("nether/get_wither_skull", "Spooky Scary Skeleton");
        advancements.put("nether/obtain_blaze_rod", "Into Fire");
        advancements.put("nether/charge_respawn_anchor", "Not Quite \"Nine\" Lives");
        advancements.put("nether/explore_nether", "Hot Tourist Destinations");
        advancements.put("nether/summon_wither", "Withering Heights");
        advancements.put("nether/brew_potion", "Local Brewery");
        advancements.put("nether/create_beacon", "Bring Home the Beacon");
        advancements.put("nether/all_potions", "A Furious Cocktail");
        advancements.put("nether/create_full_beacon", "Beaconator");
        advancements.put("nether/all_effects", "How Did We Get Here?");
        advancements.put("end/kill_dragon", "Free the End");
        advancements.put("end/dragon_egg", "The Next Generation");
        advancements.put("end/enter_end_gateway", "Remote Getaway");
        advancements.put("end/respawn_dragon", "The End... Again...");
        advancements.put("end/dragon_breath", "You Need a Mint");
        advancements.put("end/find_end_city", "The City at the End of the Game");
        advancements.put("end/elytra", "Sky's the Limit");
        advancements.put("end/levitate", "Great View From Up Here");
        advancements.put("adventure/voluntary_exile", "Voluntary Exile");
        advancements.put("adventure/kill_a_mob", "Monster Hunter");
        advancements.put("adventure/trade", "What a Deal!");
        advancements.put("adventure/honey_block_slide", "Sticky Situation");
        advancements.put("adventure/ol_betsy", "Ol' Betsy");
        advancements.put("adventure/sleep_in_bed", "Sweet Dreams");
        advancements.put("adventure/hero_of_the_village", "Hero of the Village");
        advancements.put("adventure/throw_tident", "Throwaway Joke");
        advancements.put("adventure/shoot_arrow", "Take Aim");
        advancements.put("adventure/kill_all_mobs", "Monsters Hunted");
        advancements.put("adventure/totem_of_undying", "Postmortal");
        advancements.put("adventure/summon_iron_golem", "Hired Help");
        advancements.put("adventure/two_birds_one_arrow", "Two Birds, One Arrow");
        advancements.put("adventure/whos_the_pillager_now", "Who's the Pillager Now?");
        advancements.put("adventure/arbalistic", "Arbalistic");
        advancements.put("adventure/adventuring_time", "Adeventuring Time");
        advancements.put("adventure/very_very_frightening", "Very Very Frightening");
        advancements.put("adventure/sniper_duel", "Sniper Duel");
        advancements.put("adventure/bullseye", "Bullseye");
        advancements.put("husbandry/safely_harvest_honey", "Bee Our Guest");
        advancements.put("husbandry/breed_an_animal", "The Parrots and the Bats");
        advancements.put("husbandry/tame_an_animal", "Best Friends Forever");
        advancements.put("husbandry/fishy_business", "Fishy Business");
        advancements.put("husbandry/silk_touch_nest", "Total Beelocation");
        advancements.put("husbandry/plant_seed", "A Seedy Place");
        advancements.put("husbandry/breed_all_animals", "Two by Two");
        advancements.put("husbandry/complete_catalogue", "A Complete Catalogue");
        advancements.put("husbandry/tactical_fishing", "Tactial Fishing");
        advancements.put("husbandry/balanced_diet", "A Balanced Diet");
        advancements.put("husbandry/obtain_netherite_hoe", "Serious Dedication");
    }
}
