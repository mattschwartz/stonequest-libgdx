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

        public static string TypeToString(EffectType type)
        {
            switch (type) {
                case EffectType.Equip:
                    return "equip";
                default:
                    return "use";
            }
        }
    }
}
