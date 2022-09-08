package com.chardatasave;

import com.google.inject.Provides;
import javax.inject.Inject;

import com.chardatasave.models.AnimationData;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;

import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@PluginDescriptor(
	name = "Char Data Save"
)
public class CharDataSavePlugin extends Plugin
{
	@Inject
	@Getter(AccessLevel.PUBLIC)
	private Client client;

	@Inject
	@Getter(AccessLevel.PUBLIC)
	private EventBus eventBus;

	@Inject
	private CharDataSaveConfig config;

	@Inject
	private ClientThread clientThread;
	@Inject
	private ItemManager itemManager;

	private CharDataSaveClient slc;

	private int lastTickAttacked; // last tick the client player attacked


	@Override
	protected void startUp() throws Exception
	{
		slc = new CharDataSaveClient(client, itemManager, config);
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

//	@Subscribe
//	public void onHitsplatApplied(HitsplatApplied event)
//	{
//		Player player = client.getLocalPlayer();
//		Actor actor = event.getActor();
//		Hitsplat hitsplat = event.getHitsplat();
//
//		if (player == null || actor == null || hitsplat == null || !hitsplat.isMine() || Objects.equals(actor.getName(), player.getName()))
//		{
//			return;
//		}
//
////		if (actor instanceof Player)
////		{
////			Player target = (Player) actor;
////			String targetName = target.getName();
////
////			clientThread.invokeLater(() ->
////			{
////				slc.sendHitsplat(hitsplat.getAmount(), targetName);
////			});
////		}
//		NPC target = (NPC) actor;
//		String targetName = target.getName();
//		clientThread.invokeLater(() ->
//			{
//				slc.sendHitsplat(hitsplat.getAmount(), targetName);
//			});
//	}

//	public void onAnimationChanged(AnimationChanged event)
//	{
//		// delay animation processing, since we will also want to use equipment data for deserved
//		// damage, and equipment updates are loaded shortly after the animation updates.
//		// without the invokeLater, equipped gear would be 1 tick behind the animation.
//		clientThread.invokeLater(() ->
//		{
//			// check if client player gets targeted by a player.
//			Player player = client.getLocalPlayer();
//			Actor actor = event.getActor();
//
////			if (player == null || !(actor instanceof Player))
////			{
////				return;
////			}
//
//			// if the event actor is the player, then we're attacking.
//			// otherwise, the player is being attacked. so the target attacker is the event actor
//			boolean isAttacking = Objects.equals(actor.getName(), player.getName());
//
//			// attacking is now dealt with in the onGameTick event, this is only for defending
////			if (isAttacking)
////			{
////				return;
////			}
//
////			Actor target = actor.getInteracting();
////			// make sure that the player is one of the people involved in the interaction
////			// (being attacked)
////			// I forget why exactly use names, but it behaves more consistently than comparing the whole player object.
////			if (!(target instanceof Player) ||
////					(!Objects.equals(target.getName(), player.getName())))
////			{
////				return;
////			}
////
////			int animationId = actor.getAnimation();
////			if (animationId == -1)
////			{
////				return;
////			}
////
////			AnimationData animationData = AnimationData.fromId(animationId);
////			if (animationData == null) // disregard non-combat or unknown animations
////			{
////				return;
////			}
//
//			slc.sendCombatLog(actor.getName(), false);
//		});
//	}

	@Subscribe
	public void onGameTick(GameTick event) {
		Player player = client.getLocalPlayer();

		if (player == null)
		{
			slc.sendInventoryChangeLog();
			return;
		}

		Actor target = player.getInteracting();

		if (!(target instanceof Player))
		{
			slc.sendInventoryChangeLog();
			return;
		}

		int animationId = player.getAnimation();
		if (animationId == -1)
		{
			slc.sendInventoryChangeLog();
			return;
		}

//		AnimationData animationData = AnimationData.fromId(animationId);
//		if (animationData == null) // disregard non-combat or unknown animations
//		{
//			slc.sendInventoryChangeLog();
//			return;
//		}
//
//		// if we are somehow sending more than 1 attack per tick, it has to be invalid so ignore it.
//		if (lastTickAttacked == client.getTickCount())
//		{
//			slc.sendInventoryChangeLog();
//			return;
//		}
//
//		// send combat log which will include attack/animation data
//		slc.sendCombatLog(target.getName(), true);
//		lastTickAttacked = client.getTickCount();
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}

	@Provides
	CharDataSaveConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CharDataSaveConfig.class);
	}
}
