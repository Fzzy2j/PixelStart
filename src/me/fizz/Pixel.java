package me.fizz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

public class Pixel extends JavaPlugin {

	public Pixel plugin;

	private Map<String, ItemStack> colorMap = new HashMap<String, ItemStack>();

	public void onEnable() {
		this.plugin = this;
		colorMap.put("e3e3e3", new Wool(DyeColor.WHITE).toItemStack());
		colorMap.put("e8933f", new Wool(DyeColor.ORANGE).toItemStack());
		colorMap.put("db6acf", new Wool(DyeColor.PURPLE).toItemStack());
		colorMap.put("3e98d7", new Wool(DyeColor.LIGHT_BLUE).toItemStack());
		colorMap.put("e7d558", new Wool(DyeColor.YELLOW).toItemStack());
		colorMap.put("68b735", new Wool(DyeColor.LIME).toItemStack());
		colorMap.put("f4b4d2", new Wool(DyeColor.PINK).toItemStack());
		colorMap.put("383838", new Wool(DyeColor.GRAY).toItemStack());
		colorMap.put("979797", new Wool(DyeColor.SILVER).toItemStack());
		colorMap.put("1e8395", new Wool(DyeColor.CYAN).toItemStack());
		colorMap.put("8431b5", new Wool(DyeColor.MAGENTA).toItemStack());
		colorMap.put("2c42a1", new Wool(DyeColor.BLUE).toItemStack());
		colorMap.put("542c19", new Wool(DyeColor.BROWN).toItemStack());
		colorMap.put("235d1b", new Wool(DyeColor.GREEN).toItemStack());
		colorMap.put("d13c3c", new Wool(DyeColor.RED).toItemStack());
		colorMap.put("0d0d0d", new Wool(DyeColor.BLACK).toItemStack());
		
		colorMap.put("5c5c5c", getItemWithData(Material.BEDROCK, (byte)0));
		colorMap.put("ac9892", getItemWithData(Material.BRICK, (byte)0));
		colorMap.put("9a9fac", getItemWithData(Material.CLAY, (byte)0));
		colorMap.put("0f0f0f", getItemWithData(Material.COAL_BLOCK, (byte)0));
		colorMap.put("704e35", getItemWithData(Material.DIRT, (byte)1));
		colorMap.put("727272", getItemWithData(Material.COBBLESTONE, (byte)0));
		colorMap.put("586058", getItemWithData(Material.MOSSY_COBBLESTONE, (byte)0));
		colorMap.put("00b5a9", getItemWithData(Material.DIAMOND_BLOCK, (byte)0));
		colorMap.put("775439", getItemWithData(Material.DIRT, (byte)0));
		colorMap.put("32bb55", getItemWithData(Material.EMERALD_BLOCK, (byte)0));
		colorMap.put("e3e8aa", getItemWithData(Material.ENDER_STONE, (byte)0));
		colorMap.put("f0bb2d", getItemWithData(Material.GOLD_BLOCK, (byte)0));
		colorMap.put("7e7b78", getItemWithData(Material.GRAVEL, (byte)0));
		colorMap.put("251711", getItemWithData(Material.STAINED_CLAY, (byte)15));
		colorMap.put("4a3c5b", getItemWithData(Material.STAINED_CLAY, (byte)11));
		colorMap.put("4d3424", getItemWithData(Material.STAINED_CLAY, (byte)12));
		colorMap.put("575c5c", getItemWithData(Material.STAINED_CLAY, (byte)9));
		colorMap.put("3a2b23", getItemWithData(Material.STAINED_CLAY, (byte)7));
		colorMap.put("4c542b", getItemWithData(Material.STAINED_CLAY, (byte)13));
		colorMap.put("726d8a", getItemWithData(Material.STAINED_CLAY, (byte)3));
		colorMap.put("687736", getItemWithData(Material.STAINED_CLAY, (byte)5));
		colorMap.put("96596e", getItemWithData(Material.STAINED_CLAY, (byte)2));
		colorMap.put("a35427", getItemWithData(Material.STAINED_CLAY, (byte)1));
		colorMap.put("a34f50", getItemWithData(Material.STAINED_CLAY, (byte)6));
		colorMap.put("774757", getItemWithData(Material.STAINED_CLAY, (byte)10));
		colorMap.put("8f3e30", getItemWithData(Material.STAINED_CLAY, (byte)14));
		colorMap.put("886b62", getItemWithData(Material.STAINED_CLAY, (byte)8));
		colorMap.put("d2b3a2", getItemWithData(Material.STAINED_CLAY, (byte)0));
		colorMap.put("bb8624", getItemWithData(Material.STAINED_CLAY, (byte)4));
		colorMap.put("604c2e", getItemWithData(Material.LOG, (byte)0));
		colorMap.put("93774a", getItemWithData(Material.WOOD, (byte)0));
		colorMap.put("aa610c", getItemWithData(Material.PUMPKIN, (byte)0));
		colorMap.put("e3250b", getItemWithData(Material.REDSTONE_BLOCK, (byte)0));
		colorMap.put("a2511e", getItemWithData(Material.SAND, (byte)1));
		colorMap.put("cfc795", getItemWithData(Material.SAND, (byte)0));
		colorMap.put("776052", getItemWithData(Material.SOUL_SAND, (byte)0));
		colorMap.put("b1b34a", getItemWithData(Material.SPONGE, (byte)0));
		colorMap.put("808080", getItemWithData(Material.STONE, (byte)0));
		colorMap.put("666666", getItemWithData(Material.SMOOTH_BRICK, (byte)0));
		colorMap.put("808085", getItemWithData(Material.STONE, (byte)5));
		colorMap.put("b1b1b4", getItemWithData(Material.STONE, (byte)3));
		colorMap.put("ab7d6a", getItemWithData(Material.STONE, (byte)1));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if (sender instanceof Player) {
			if (label.equalsIgnoreCase("start")) {
				BufferedImage image = null;
				URL url = null;
				try {
					url = new URL("http://i.imgur.com/xFeNpsH.jpg");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				try {
					image = ImageIO.read(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Location loc = ((Player) sender).getLocation();
				for (int x = 0; x < image.getWidth(); x++) {
					for (int y = 0; y < image.getHeight(); y++) {
						int color = image.getRGB(x, y);

						int red = (color & 0x00ff0000) >> 16;
						int green = (color & 0x0000ff00) >> 8;
						int blue = color & 0x000000ff;
						ItemStack block = getClosestColorData(red, green, blue);
						Block blocks = loc.clone().add(x, 0, y).getBlock();
						blocks.setType(block.getType());
						blocks.setData(block.getData().getData());
					}
				}
			}
			if (label.equalsIgnoreCase("test")) {
				((Player) sender).getInventory().addItem(getItemWithData(Material.STAINED_CLAY, (byte)10));
			}
		}
		return false;
	}

	public static Color hex2Rgb(String colorStr) {
		Color color = new Color(Integer.valueOf(colorStr.substring(0, 2), 16), Integer.valueOf(colorStr.substring(2, 4), 16), Integer.valueOf(
				colorStr.substring(4, 6), 16));
		return color;
	}

	public ItemStack getClosestColorData(int r1, int g1, int b1) {
		double difference = Double.MAX_VALUE;
		String closestRGB = null;

		for (String rawRGB : colorMap.keySet()) {
			Color color = hex2Rgb(rawRGB);
			int r2 = color.getRed();
			int g2 = color.getGreen();
			int b2 = color.getBlue();

			double diff = Math.sqrt(Math.pow((r2 - r1), 2) + Math.pow((g2 - g1), 2) + Math.pow(b2 - b1, 2));

			if (diff < difference) {
				closestRGB = rawRGB;
				difference = diff;
			}
		}

		return colorMap.get(closestRGB);
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getItemWithData(Material mat, byte data) {
		ItemStack i = new ItemStack(mat);
		i.setData(new MaterialData(mat, data));
		return i;
	}
}
