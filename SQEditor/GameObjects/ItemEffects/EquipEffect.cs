using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SQEditor.GameObjects.ItemEffects
{
    public class EquipEffect : ItemEffect
    {
        public EquipEffect()
        {
            Type = EffectType.Equip;
        }
    }
}
