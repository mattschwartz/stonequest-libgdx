using SQEditor.GameObjects.ItemEffects;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace SQEditor.GameObjects.Items
{
    public class Item : Serializable
    {
        #region Data

        public string Name;
        public int Level;
        public int SellValue;
        public string Type;
        public string Description;
        public Image Artwork;
        public List<ItemEffect> EquipEffects;
        public List<ItemEffect> UseEffects;

        #endregion

        #region Constructor

        public Item()
        {
            EquipEffects = new List<ItemEffect>();
            UseEffects = new List<ItemEffect>();
        }

        #endregion

        #region XML Writing

        public override string GetType()
        {
            return "items";
        }

        public override XElement ToXML()
        {
            var result = new XElement("item");

            result.Add(new XElement("name", Name));
            result.Add(new XElement("level", Level));
            result.Add(new XElement("type", Type));
            result.Add(new XElement("sellValue", SellValue));
            result.Add(new XElement("description", Description));
            result.Add(new XElement("equipEffects", EquipEffects.Count));
            result.Add(new XElement("useEffects", UseEffects.Count));

            return result;
        }

        #endregion

        #region Save

        public override void Save()
        {
            string dir;
            string formattedName = Name;
            Regex pattern = new Regex(@"\W|_");

            formattedName = pattern.Replace(Name.ToLower(), "");
            dir = FileUtility.GetResourcesRootPath() + "items\\" + Type + "\\" + formattedName + "\\";

            if (!Directory.Exists(dir)) {
                Directory.CreateDirectory(dir);
            }

            SaveArtwork(dir);
            SaveEffects(dir);
        }

        private void SaveArtwork(string dir)
        {
            dir += "artwork.png";
            //Artwork.Save(dir, ImageFormat.Png);
        }

        private void SaveEffects(string dir)
        {
            int i = 0;
            foreach (var effect in EquipEffects) {
                File.WriteAllText(dir + "equip_" + (i++) + ".py", effect.ToFile());
            }

            i = 0;
            foreach (var effect in UseEffects) {
                File.WriteAllText(dir + "use_" + (i++) + ".py", effect.ToFile());
            }
        }

        #endregion
    }
}
