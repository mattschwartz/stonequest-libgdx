using System.Collections.Generic;
using System.Drawing;
using System.Xml.Linq;

namespace SQEditor.GameObjects
{
    class Tile : Serializable
    {
        public enum TileType
        {
            Environment,
            Building,
            Doodad,
            Prop
        }

        public string Name;
        public string StepSound;
        public bool Collision;
        public List<Point> Bounds;
        public TileType Type;

        public Tile()
        {
            Bounds = new List<Point>();
        }

        public override string GetType()
        {
            return "tiles";
        }

        public override XElement ToXML()
        {
            return null;
        }

        public override void Save()
        {
        }
    }
}
