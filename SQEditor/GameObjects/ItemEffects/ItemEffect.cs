using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SQEditor.GameObjects.ItemEffects
{
    public class ItemEffect
    {
        public enum EffectType
        {
            Equip,
            Use
        }

        public string Name;
        public string Script;
        public EffectType Type;

        public string TypeToString()
        {
            switch (Type) {
                case EffectType.Equip:
                    return "Equip";
                case EffectType.Use:
                    return "Use";
                default:
                    return "";
            }
        }

        public string ToFile()
        {
            string program = "import StoneQuest.Modding\n\n";

            program += "# " + Name + "\n";
            program += Script + "\n";

            return program;
        }

        public override string ToString()
        {
            return TypeToString() + ": " + Name;
        }
    }
}
