using SQEditor.GameObjects.ItemEffects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace SQEditor.GameObjects.Items
{
    public class Item
    {
        public string Name;
        public int Level;
        public int SellValue;
        public string Type;
        public string Description;
        public List<EquipEffect> EquipEffects;
        public List<UseEffect> UseEffects;

        public Item()
        {
            EquipEffects = new List<EquipEffect>();
            UseEffects = new List<UseEffect>();
        }

        public virtual XElement GetXML()
        {
            var result = new XElement("item");
            var equipEffects = new XElement("equipEffects");
            var useEffects = new XElement("useEffects");

            result.Add(new XElement("name", Name));
            result.Add(new XElement("level", Level));
            result.Add(new XElement("type", Type));
            result.Add(new XElement("sellValue", SellValue));
            result.Add(new XElement("imagePath", GetImagePath()));
            result.Add(new XElement("description", Description));

            #region Item Effects
            foreach (var effect in EquipEffects) {
                var element = new XElement("equipEffect");
                element.Add(new XElement("displayName", effect.Name));
                element.Add(new XElement("script", effect.Script));
                equipEffects.Add("equipEffect", element);
            }

            foreach (var effect in UseEffects) {
                var element = new XElement("useEffect");
                element.Add(new XElement("displayName", effect.Name));
                element.Add(new XElement("script", effect.Script));
                useEffects.Add("useEffect", element);
            }

            result.Add(equipEffects);
            result.Add(useEffects);
            #endregion

            return result;
        }

        private string GetImagePath()
        {
            string formattedName = Name;
            Regex pattern = new Regex(@"\W|_");

            formattedName = pattern.Replace(Name.ToLower(), "");

            return "items/" + Type + "/" + formattedName + ".png";
        }
    }
}
